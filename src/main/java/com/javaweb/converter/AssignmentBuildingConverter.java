package com.javaweb.converter;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssignmentBuildingConverter {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private UserRepository userRepository;

    public List<AssignmentBuildingEntity> dtoToEntity(AssignmentBuildingDTO assignmentBuildingDTO) {
        return assignmentBuildingDTO.getStaffIds().stream().map(staffId -> {
            AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
            assignmentBuildingEntity.setBuildingEntity(buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).get());
            assignmentBuildingEntity.setUserEntity(userRepository.findById(staffId).get());
            return assignmentBuildingEntity;
        }).collect(Collectors.toList());
    }
}
