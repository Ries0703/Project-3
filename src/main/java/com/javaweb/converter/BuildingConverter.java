package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BuildingConverter {

	@Autowired
	private ModelMapper modelMapper;

	public BuildingSearchResponse entityToResponse(BuildingEntity building) {
		String address = String.join(", ",
				building.getStreet(),
				building.getWard(),
				DistrictCode.valueOf(building.getDistrictCode()).getDistrictName());
		String rentArea = building.getRentAreaEntities()
		    .stream()
		    .map(o -> o.getValue().toString())
		    .collect(Collectors.joining(", "));
		BuildingSearchResponse dto = modelMapper.map(building, BuildingSearchResponse.class);
		dto.setAddress(address);
		dto.setRentArea(rentArea);
		return dto;
	}

	public BuildingEntity dtoToEntity(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);


		return buildingEntity;
	}
}
