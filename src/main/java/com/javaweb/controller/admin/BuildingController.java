package com.javaweb.controller.admin;


import com.javaweb.enums.DistrictCode;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    IUserService userService;

    @GetMapping(value = "/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute("buildingSearchRequest") BuildingSearchRequest buildingSearchRequest) {
        List<BuildingSearchResponse> buildings = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
            buildingSearchResponse.setId((long) i);
            buildingSearchResponse.setName("Building Number " + i);
            buildingSearchResponse.setAddress("street " + i + ", ward " + i + ", district " + i);
            buildingSearchResponse.setNumberOfBasement((long) i);
            buildingSearchResponse.setManagerName("Nguyen Van " + i);
            buildingSearchResponse.setBrokerageFee(i * 1000D);
            buildingSearchResponse.setFloorArea(i * 1000L);
            buildings.add(buildingSearchResponse);
        }
        return new ModelAndView("admin/building/list")
                .addObject("buildingList", buildings)
                .addObject("staffs", userService.getStaffs())
                .addObject("districtCodes", DistrictCode.districtMap())
                .addObject("typeCodes", TypeCode.typeCodeMap());
    }




    @GetMapping(value = "/admin/building-edit")
    public ModelAndView addBuilding(@ModelAttribute(value = "buildingEdit") BuildingDTO buildingDTO) {
        return new ModelAndView("admin/building/edit")
                .addObject("buildingEdit", buildingDTO)
                .addObject("districtCodes", DistrictCode.districtMap())
                .addObject("typeCodes", TypeCode.typeCodeMap());
    }

    @GetMapping(value = "/admin/building-edit-{id}")
    public ModelAndView editBuilding(@PathVariable(value = "id") Long id) {
        //get building by id
        BuildingDTO dto = new BuildingDTO();
        dto.setId(id);
        dto.setName("building 1");
        dto.setDistrict(DistrictCode.QUAN_1);
        dto.setWard("ward 1");
        dto.setStreet("street 1");
        dto.setStructure("structure 1");
        dto.setNumberOfBasement(12L);
        dto.setFloorArea(123L);
        dto.setDirection("south");
        dto.setLevel(123L);
        dto.setRentArea(123123L);
        dto.setRentPrice(123123L);
        dto.setRentPriceDescription("a lot");
        dto.setServiceFee(123123L);
        dto.setCarFee(12312L);
        dto.setMotoFee(123213L);
        dto.setOvertimeFee(123123L);
        dto.setElectricityFee(12321L);
        dto.setDeposit(123123L);
        dto.setPayment(123123L);
        dto.setRentTime("veri long");
        dto.setDecorationTime("like, veri veri longu");
        dto.setManagerName("mr beast");
        dto.setManagerPhone("123123123");
        dto.setBrokerageFee(123123231D);
        dto.setNote("this is a mock building");
        dto.setTypeCode(Arrays.asList(TypeCode.NGUYEN_CAN, TypeCode.TANG_TRET));
        return new ModelAndView("admin/building/edit")
                .addObject("buildingEdit", dto)
                .addObject("districtCodes", DistrictCode.districtMap())
                .addObject("typeCodes", TypeCode.typeCodeMap());
    }
}
