package com.javaweb.controller.admin;


import com.javaweb.enums.DistrictCode;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    IUserService userService;

    @Autowired
    IBuildingService buildingService;

    @GetMapping(value = "/admin/building-list")
    public ModelAndView buildingList(@ModelAttribute("buildingSearchRequest") BuildingSearchRequest buildingSearchRequest) {
        return new ModelAndView("admin/building/list")
                .addObject("buildingList", buildingService.findAll(buildingSearchRequest))
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
        return new ModelAndView("admin/building/edit")
                .addObject("buildingEdit", buildingService.findById(id))
                .addObject("districtCodes", DistrictCode.districtMap())
                .addObject("typeCodes", TypeCode.typeCodeMap());
    }
}
