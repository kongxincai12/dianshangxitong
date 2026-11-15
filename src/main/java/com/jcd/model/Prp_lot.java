package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class Prp_lot {
    private String lotid;

    private String lotname;

    private String type;

    private String category;

    private String description;

    private String productpn;

    private String workorderid;

    private String processid;

    private String mbomid;

    private String lineid;

    private String status;

    private String productionmode;

    private BigDecimal jointboardnum;

    private BigDecimal flappernum;

    private String projectnum;

    private BigDecimal hardwarever;

    private BigDecimal totalqty;

    private BigDecimal inputqty;

    private BigDecimal outputqty;

    private Date planstartdate;

    private Date planenddate;

    private Date firstinputdate;

    private Date lastoutputdate;

    private Date lastactivitydate;

    private String releasestatus;

    private String username;

    private Date createdate;

    private String isduckboard;

    private String phonetype;

    private String section;

    private String producttype;

    private String subsection;

    private String hasnewmaterial;

    private String stage;

    private BigDecimal defectqty;

    private BigDecimal wipqty;

    private BigDecimal panelpcs;

    private BigDecimal workorderstartqty;

    private BigDecimal workorderlotsqty;

    private BigDecimal scrapqty;

    private String datecode;

    private Integer packageqty;

    private String issplitaftersmt;

    private String toLocation;

    private String shipid;

    private String ospvendorcode;

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid == null ? null : lotid.trim();
    }

    public String getLotname() {
        return lotname;
    }

    public void setLotname(String lotname) {
        this.lotname = lotname == null ? null : lotname.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getProductpn() {
        return productpn;
    }

    public void setProductpn(String productpn) {
        this.productpn = productpn == null ? null : productpn.trim();
    }

    public String getWorkorderid() {
        return workorderid;
    }

    public void setWorkorderid(String workorderid) {
        this.workorderid = workorderid == null ? null : workorderid.trim();
    }

    public String getProcessid() {
        return processid;
    }

    public void setProcessid(String processid) {
        this.processid = processid == null ? null : processid.trim();
    }

    public String getMbomid() {
        return mbomid;
    }

    public void setMbomid(String mbomid) {
        this.mbomid = mbomid == null ? null : mbomid.trim();
    }

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid == null ? null : lineid.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getProductionmode() {
        return productionmode;
    }

    public void setProductionmode(String productionmode) {
        this.productionmode = productionmode == null ? null : productionmode.trim();
    }

    public BigDecimal getJointboardnum() {
        return jointboardnum;
    }

    public void setJointboardnum(BigDecimal jointboardnum) {
        this.jointboardnum = jointboardnum;
    }

    public BigDecimal getFlappernum() {
        return flappernum;
    }

    public void setFlappernum(BigDecimal flappernum) {
        this.flappernum = flappernum;
    }

    public String getProjectnum() {
        return projectnum;
    }

    public void setProjectnum(String projectnum) {
        this.projectnum = projectnum == null ? null : projectnum.trim();
    }

    public BigDecimal getHardwarever() {
        return hardwarever;
    }

    public void setHardwarever(BigDecimal hardwarever) {
        this.hardwarever = hardwarever;
    }

    public BigDecimal getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(BigDecimal totalqty) {
        this.totalqty = totalqty;
    }

    public BigDecimal getInputqty() {
        return inputqty;
    }

    public void setInputqty(BigDecimal inputqty) {
        this.inputqty = inputqty;
    }

    public BigDecimal getOutputqty() {
        return outputqty;
    }

    public void setOutputqty(BigDecimal outputqty) {
        this.outputqty = outputqty;
    }

    public Date getPlanstartdate() {
        return planstartdate;
    }

    public void setPlanstartdate(Date planstartdate) {
        this.planstartdate = planstartdate;
    }

    public Date getPlanenddate() {
        return planenddate;
    }

    public void setPlanenddate(Date planenddate) {
        this.planenddate = planenddate;
    }

    public Date getFirstinputdate() {
        return firstinputdate;
    }

    public void setFirstinputdate(Date firstinputdate) {
        this.firstinputdate = firstinputdate;
    }

    public Date getLastoutputdate() {
        return lastoutputdate;
    }

    public void setLastoutputdate(Date lastoutputdate) {
        this.lastoutputdate = lastoutputdate;
    }

    public Date getLastactivitydate() {
        return lastactivitydate;
    }

    public void setLastactivitydate(Date lastactivitydate) {
        this.lastactivitydate = lastactivitydate;
    }

    public String getReleasestatus() {
        return releasestatus;
    }

    public void setReleasestatus(String releasestatus) {
        this.releasestatus = releasestatus == null ? null : releasestatus.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getIsduckboard() {
        return isduckboard;
    }

    public void setIsduckboard(String isduckboard) {
        this.isduckboard = isduckboard == null ? null : isduckboard.trim();
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype == null ? null : phonetype.trim();
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section == null ? null : section.trim();
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype == null ? null : producttype.trim();
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection == null ? null : subsection.trim();
    }

    public String getHasnewmaterial() {
        return hasnewmaterial;
    }

    public void setHasnewmaterial(String hasnewmaterial) {
        this.hasnewmaterial = hasnewmaterial == null ? null : hasnewmaterial.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }

    public BigDecimal getDefectqty() {
        return defectqty;
    }

    public void setDefectqty(BigDecimal defectqty) {
        this.defectqty = defectqty;
    }

    public BigDecimal getWipqty() {
        return wipqty;
    }

    public void setWipqty(BigDecimal wipqty) {
        this.wipqty = wipqty;
    }

    public BigDecimal getPanelpcs() {
        return panelpcs;
    }

    public void setPanelpcs(BigDecimal panelpcs) {
        this.panelpcs = panelpcs;
    }

    public BigDecimal getWorkorderstartqty() {
        return workorderstartqty;
    }

    public void setWorkorderstartqty(BigDecimal workorderstartqty) {
        this.workorderstartqty = workorderstartqty;
    }

    public BigDecimal getWorkorderlotsqty() {
        return workorderlotsqty;
    }

    public void setWorkorderlotsqty(BigDecimal workorderlotsqty) {
        this.workorderlotsqty = workorderlotsqty;
    }

    public BigDecimal getScrapqty() {
        return scrapqty;
    }

    public void setScrapqty(BigDecimal scrapqty) {
        this.scrapqty = scrapqty;
    }

    public String getDatecode() {
        return datecode;
    }

    public void setDatecode(String datecode) {
        this.datecode = datecode == null ? null : datecode.trim();
    }

    public Integer getPackageqty() {
        return packageqty;
    }

    public void setPackageqty(Integer packageqty) {
        this.packageqty = packageqty;
    }

    public String getIssplitaftersmt() {
        return issplitaftersmt;
    }

    public void setIssplitaftersmt(String issplitaftersmt) {
        this.issplitaftersmt = issplitaftersmt == null ? null : issplitaftersmt.trim();
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation == null ? null : toLocation.trim();
    }

    public String getShipid() {
        return shipid;
    }

    public void setShipid(String shipid) {
        this.shipid = shipid == null ? null : shipid.trim();
    }

    public String getOspvendorcode() {
        return ospvendorcode;
    }

    public void setOspvendorcode(String ospvendorcode) {
        this.ospvendorcode = ospvendorcode == null ? null : ospvendorcode.trim();
    }
}