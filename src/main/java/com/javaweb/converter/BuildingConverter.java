package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.enums.DistrictCode;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RentAreaConverter rentAreaConverter;

	public BuildingDTO entityToDto(BuildingEntity building) {
		List<TypeCode> typeCode = Arrays.stream(
				building.getType().split("[ ,]+"))
				.map(TypeCode::valueOf)
				.collect(Collectors.toList()
				);
		String rentArea = building.getRentAreaEntities().stream().map(area -> area.getValue().toString()).collect(Collectors.joining(", "));
		BuildingDTO buildingDTO = modelMapper.map(building, BuildingDTO.class);
		buildingDTO.setTypeCode(typeCode);
		buildingDTO.setRentArea(rentArea);
		return buildingDTO;
	}


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
		buildingEntity.setDistrictCode(buildingDTO.getDistrict().toString());

		//delete square brackets resulted from mapping List to String of modelMapper
		StringBuilder type = new StringBuilder(buildingEntity.getType())
									.deleteCharAt(buildingEntity.getType().length() - 1)
									.deleteCharAt(0);

		buildingEntity.setType(type.toString());
		String[] rentAreas = buildingDTO.getRentArea().trim().split("[ ,]+");
		buildingEntity.setRentAreaEntities(
				Arrays.stream(rentAreas)
				.map(area -> rentAreaConverter.stringToRentArea(area, buildingEntity))
				.collect(Collectors.toList())
		);
		return buildingEntity;
	}
}
