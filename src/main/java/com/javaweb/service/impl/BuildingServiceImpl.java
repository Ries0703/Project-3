package com.javaweb.service.impl;

import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.converter.RentAreaConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements IBuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingConverter buildingConverter;
	@Autowired
	private RentAreaRepository rentAreaRepository;
	@Autowired
	private AssignmentBuildingRepository assignmentBuildingRepository;

	@Override
	public List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest) {
		return buildingRepository.findAll(buildingSearchRequest)
		    .stream()
		    .map(buildingConverter::entityToResponse)
		    .collect(Collectors.toList());
	}

	@Override
	public BuildingDTO findById(Long id) {
		Optional<BuildingEntity> buildingEntity = buildingRepository.findById(id);
		if (!buildingEntity.isPresent()) {
			return new BuildingDTO();
		}
		return buildingConverter.entityToDto(buildingEntity.get());
	}

	@Override
	public void addBuilding(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.dtoToEntity(buildingDTO);
		buildingRepository.save(buildingEntity);
		rentAreaRepository.saveAll(buildingEntity.getRentAreaEntities());
	}

	@Override
	public void editBuilding(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.dtoToEntity(buildingDTO);
		rentAreaRepository.deleteByBuildingIdIn(Collections.singletonList(buildingEntity.getId()));
		buildingRepository.save(buildingEntity);
		rentAreaRepository.saveAll(buildingEntity.getRentAreaEntities());
	}

	@Override
	public void removeBuilding(List<Long> ids) {
		rentAreaRepository.deleteByBuildingIdIn(ids);
		assignmentBuildingRepository.deleteByBuildingEntityIdIn(ids);
		buildingRepository.deleteByIdIn(ids);
	}
}
