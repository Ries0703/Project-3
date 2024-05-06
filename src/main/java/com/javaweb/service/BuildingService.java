package com.javaweb.service;




import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;

import java.util.List;


public interface BuildingService {
	List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest);
	void addBuilding(BuildingDTO buildingDTO);
	void removeBuilding(List<Long> id);
}
