package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import org.springframework.stereotype.Component;

@Component
public class RentAreaConverter {
    public RentAreaEntity stringToRentArea(String rentArea, BuildingEntity buildingEntity) {
        RentAreaEntity rentAreaEntity = new RentAreaEntity();
        rentAreaEntity.setValue(Integer.valueOf(rentArea.trim()));
        rentAreaEntity.setBuildingEntity(buildingEntity);
        return rentAreaEntity;

    }
}
