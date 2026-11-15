package com.jcd.controller;

import com.jcd.model.EquipmentStationBinding;
import com.jcd.service.EquipmentStationBindingService;
import com.jcd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/mes")
public class EquipmentStationBindingController {
    @Autowired
    private EquipmentStationBindingService bindingService;

    @GetMapping("/eqp-station-rel/effective-by-eqp/{equipmentId}")
    public Result<List<EquipmentStationBinding>> listEffectiveByEquipment(@PathVariable String equipmentId) {
        return Result.success(bindingService.listEffectiveByEquipment(equipmentId));
    }
}
