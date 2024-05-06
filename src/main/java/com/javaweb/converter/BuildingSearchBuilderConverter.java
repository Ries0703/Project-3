package com.javaweb.converter;

import com.javaweb.enums.TypeCode;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.utils.MapUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchRequest toBuildingSearchBuilder(Map<String, Object> params, List<TypeCode> typeCodes) {
		return BuildingSearchRequest.builder()
                .name(MapUtil.getString(params.get("name")))
                .street(MapUtil.getString(params.get("street")))
                .ward(MapUtil.getString(params.get("ward")))
                .district(MapUtil.getString(params.get("district")))
                .numberOfBasement(MapUtil.getLong(params.get("numberOfBasement")))
                .floorArea(MapUtil.getLong(params.get("floorArea")))
                .direction(MapUtil.getString(params.get("direction")))
                .level(MapUtil.getLong(params.get("level")))
                .areaFrom(MapUtil.getLong(params.get("areaFrom")))
                .areaTo(MapUtil.getLong(params.get("areaTo")))
                .rentPriceFrom(MapUtil.getLong(params.get("rentPriceFrom")))
                .rentPriceTo(MapUtil.getLong(params.get("rentPriceTo")))
                .managerName(MapUtil.getString(params.get("managerName")))
                .managerPhone(MapUtil.getString(params.get("managerPhone")))
                .staffId(MapUtil.getLong(params.get("staffId")))
                .typeCode(typeCodes)
                .build();
	}
}