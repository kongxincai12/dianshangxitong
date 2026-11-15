package com.jcd.service.qafa;

import lombok.Data;

import java.util.Date;
import java.util.List;

public interface SmbBrowseService {

    /** 浏览相对路径 (相对 qa.smb.root) 的子目录与 xlsx 文件 */
    BrowseResult list(String relativePath) throws Exception;

    /** 把 SMB 上文件复制到本地临时目录, 返回本地路径 */
    String copyToTemp(String relativePath) throws Exception;

    /** 配置根目录 */
    String getRoot();

    @Data
    class BrowseResult {
        private String relativePath;
        private List<Entry> entries;
    }

    @Data
    class Entry {
        private String name;
        private boolean directory;
        private Long size;
        private Date lastModified;
    }
}
