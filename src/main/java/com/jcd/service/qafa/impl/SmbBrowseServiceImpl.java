package com.jcd.service.qafa.impl;

import com.jcd.exception.BusinessException;
import com.jcd.service.qafa.SmbBrowseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Windows 部署: pdaserver 直接通过 UNC 路径访问 SMB. 不需要 jcifs.
 */
@Service
public class SmbBrowseServiceImpl implements SmbBrowseService {

    @Value("${qa.smb.root:}")
    private String root;

    @Value("${qa.smb.temp-dir:./temp/lab-excel}")
    private String tempDir;

    @Value("${qa.smb.max-file-size-mb:10}")
    private long maxFileSizeMb;

    @PostConstruct
    public void init() {
        root = fixMojibake(root);
        // 延迟创建目录，避免启动时访问网络路径
        // try {
        //     Files.createDirectories(Paths.get(tempDir));
        // } catch (IOException ignore) {
        // }
    }

    @Override
    public String getRoot() {
        return root;
    }

    @Override
    public BrowseResult list(String relativePath) throws Exception {
        if (root == null || root.isEmpty()) {
            throw new BusinessException(500, "未配置 qa.smb.root, 请联系管理员");
        }
        Path dir;
        try {
            dir = resolveSafely(relativePath);
        } catch (BusinessException be) {
            throw be;
        }
        if (!Files.exists(dir)) {
            throw new BusinessException(404,
                "无法访问路径 [" + dir + "]; 请检查共享根 " + root + " 是否在线、pdaserver 服务账号是否有访问权限");
        }
        if (!Files.isDirectory(dir)) throw new BusinessException(400, "不是目录: " + relativePath);

        List<Entry> list = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path p : stream) {
                String name = p.getFileName().toString();
                boolean isDir = Files.isDirectory(p);
                if (!isDir && !name.toLowerCase(Locale.ROOT).endsWith(".xlsx")) continue;
                Entry e = new Entry();
                e.setName(name);
                e.setDirectory(isDir);
                if (!isDir) {
                    BasicFileAttributes a = Files.readAttributes(p, BasicFileAttributes.class);
                    e.setSize(a.size());
                    e.setLastModified(new Date(a.lastModifiedTime().toMillis()));
                }
                list.add(e);
            }
        }
        // 目录在前, 名字倒序(常见日期文件夹 4.16 在前)
        list.sort((a, b) -> {
            if (a.isDirectory() != b.isDirectory()) return a.isDirectory() ? -1 : 1;
            return b.getName().compareToIgnoreCase(a.getName());
        });
        BrowseResult r = new BrowseResult();
        r.setRelativePath(relativePath == null ? "" : relativePath);
        r.setEntries(list);
        return r;
    }

    @Override
    public String copyToTemp(String relativePath) throws Exception {
        Path src = resolveSafely(relativePath);
        if (!Files.exists(src) || Files.isDirectory(src)) {
            throw new BusinessException(404, "文件不存在: " + relativePath);
        }
        long sizeMb = Files.size(src) / (1024 * 1024);
        if (sizeMb > maxFileSizeMb) {
            throw new BusinessException(413, "文件过大: " + sizeMb + "MB > " + maxFileSizeMb + "MB");
        }
        String name = System.currentTimeMillis() + "_" + src.getFileName().toString();
        Path dst = Paths.get(tempDir, name).toAbsolutePath();
        // 确保目录存在
        Files.createDirectories(dst.getParent());
        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
        return dst.toString();
    }

    /**
     * 解析相对路径并阻断 ".." 越权.
     */
    private Path resolveSafely(String relativePath) {
        if (root == null || root.isEmpty()) {
            throw new BusinessException(500, "未配置 qa.smb.root");
        }
        String rel = relativePath == null ? "" : fixMojibake(relativePath).replace('\\', '/').trim();
        if (rel.contains("..")) throw new BusinessException(400, "非法路径");
        if (rel.startsWith("/")) rel = rel.substring(1);

        Path base = Paths.get(root).toAbsolutePath().normalize();
        Path target = (rel.isEmpty() ? base : base.resolve(rel)).normalize();
        if (!target.toString().startsWith(base.toString())) {
            throw new BusinessException(400, "越权访问");
        }
        return target;
    }

    private String fixMojibake(String value) {
        if (value == null || value.isEmpty() || !looksMojibake(value)) return value;
        String decoded = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return countCjk(decoded) > countCjk(value) ? decoded : value;
    }

    private boolean looksMojibake(String value) {
        return value.contains("Ã") || value.contains("Â") || value.contains("ç")
                || value.contains("å") || value.contains("é") || value.contains("è");
    }

    private int countCjk(String value) {
        int count = 0;
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (ch >= '\u4e00' && ch <= '\u9fff') count++;
        }
        return count;
    }
}
