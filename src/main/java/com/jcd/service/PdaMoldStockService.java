package com.jcd.service;

import com.jcd.model.Location;
import com.jcd.model.PdaMoldStock;

import java.util.List;

public interface PdaMoldStockService {
    PdaMoldStock getStockByMoldCode(String moldCode);

    Integer checkByLocationName(String locationName);

    Boolean insertion(PdaMoldStock pdaMoldStock, String employeeId);

    Location getLocationByLocationName(String locationName);

    Integer getMoleByMoldCode(String moldCode);

    Integer checkLocationOutStatus(String locationCode);

    Boolean outOfStock(String locationCode,String moldCode,String employeeId);

    Integer checkMoldInLocation(String moldCode, String locationCode);

    List<PdaMoldStock> searchStock(String moldCode, String locationCode);

    List<String> getMoldsByLocationCode(String locationCode);
}
