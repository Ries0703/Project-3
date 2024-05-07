package com.javaweb.repository;

import com.javaweb.entity.AssignmentBuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity, Long> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM assignmentbuilding where buildingid in(:ids)", nativeQuery = true)
    void deleteByBuildingEntityIdIn(List<Long> ids);
}
