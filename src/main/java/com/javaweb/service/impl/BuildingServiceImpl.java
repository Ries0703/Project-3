package com.javaweb.service.impl;

import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private BuildingConverter buildingConverter;
	@Autowired
	private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

	@Override
	public List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest) {
		return buildingRepository.findAll(buildingSearchRequest)
		    .stream()
		    .map(buildingConverter::entityToResponse)
		    .collect(Collectors.toList());
	}

	@Override
	public void addBuilding(BuildingDTO buildingRequest) {
		buildingRepository.save(buildingConverter.dtoToEntity(buildingRequest));
	}

	@Override
	public void removeBuilding(List<Long> id) {
		buildingRepository.deleteByIdIn(id);
	}

}
