package com.javaweb.repository;

import com.javaweb.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM rentarea WHERE buildingid IN (:ids)", nativeQuery = true)
    void deleteByBuildingIdIn(List<Long> ids);
}
