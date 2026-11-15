package com.jcd.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class LotInfoDto {
    private String product;
    private Integer panelPcs;
    private BigDecimal wipQty;
    private String lotCode;
    private String status;
    private String lotSite;
    private Integer sumPnl;
    private Integer sumPcs;
    private Integer sumPackQty;
    private int standardCapacity;


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getPanelPcs() {
        return panelPcs;
    }

    public void setPanelPcs(Integer panelPcs) {
        this.panelPcs = panelPcs;
    }

    public BigDecimal getWipQty() {
        return wipQty;
    }

    public void setWipQty(BigDecimal wipQty) {
        this.wipQty = wipQty;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLotSite() {
        return lotSite;
    }

    public void setLotSite(String lotSite) {
        this.lotSite = lotSite;
    }

    public Integer getSumPcs() {
        return sumPcs;
    }

    public void setSumPcs(Integer sumPcs) {
        this.sumPcs = sumPcs;
    }

    public Integer getSumPnl() {
        return sumPnl;
    }

    public void setSumPnl(Integer sumPnl) {
        this.sumPnl = sumPnl;
    }

    public Integer getSumPackQty(Integer sumPackQty) {
        return this.sumPackQty;
    }

    public void setSumPackQty(Integer sumPackQty) {
        this.sumPackQty = sumPackQty;
    }

    public int getStandardCapacity() {
        return standardCapacity;
    }

    public void setStandardCapacity(int standardCapacity) {
        this.standardCapacity = standardCapacity;
    }

    public Integer getSumPackQty() {
        return sumPackQty;
    }
}
