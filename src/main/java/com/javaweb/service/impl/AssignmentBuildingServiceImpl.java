package com.javaweb.service.impl;

import com.javaweb.converter.AssignmentBuildingConverter;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.service.IAssignmentBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;

@Service
public class AssignmentBuildingServiceImpl implements IAssignmentBuildingService {

    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;

    @Autowired
    private AssignmentBuildingConverter assignmentBuildingConverter;

    @Override
    public void assignStaffsToBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
        assignmentBuildingRepository.deleteByBuildingEntityIdIn(Collections.singletonList(assignmentBuildingDTO.getBuildingId()));
        assignmentBuildingRepository.saveAll(assignmentBuildingConverter.dtoToEntity(assignmentBuildingDTO));
    }
}
