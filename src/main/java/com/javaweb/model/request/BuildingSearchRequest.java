package com.javaweb.model.request;

import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.AbstractDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class BuildingSearchRequest extends AbstractDTO<BuildingSearchRequest> {
    private String name;
    private String street;
    private String ward;
    private String district;
    private Long numberOfBasement;
    private Long floorArea;
    private String direction;
    private Long level;
    private Long areaFrom;
    private Long areaTo;
    private Long rentPriceFrom;
    private Long rentPriceTo;
    private String managerName;
    private String managerPhone;
    private Long staffId;
    private List<TypeCode> typeCode;
}
