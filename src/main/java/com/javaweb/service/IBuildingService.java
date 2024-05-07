package com.javaweb.service;




import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;

import java.util.List;


public interface IBuildingService {
	List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest);
	BuildingDTO findById(Long id);
	void addBuilding(BuildingDTO buildingDTO);
	void editBuilding(BuildingDTO buildingDTO);
	void removeBuilding(List<Long> id);
}
