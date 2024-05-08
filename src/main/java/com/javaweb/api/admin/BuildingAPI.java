package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.IAssignmentBuildingService;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/buildings")
public class BuildingAPI {
    @Autowired
    IBuildingService buildingService;

    @Autowired
    IAssignmentBuildingService assignmentBuildingService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<BuildingSearchResponse> getBuilding(@RequestParam BuildingSearchRequest buildingSearchRequest) {
        return buildingService.findAll(buildingSearchRequest);
    }

    @PutMapping
    public String addBuilding(@RequestBody BuildingDTO buildingDTO) {
        buildingService.addOrEditBuilding(buildingDTO);
        return "add building successfully";
    }

    @PostMapping
    public String editBuilding(@RequestBody BuildingDTO building) {
        buildingService.addOrEditBuilding(building);
        return "building updated successfully";
    }

    @DeleteMapping(value = "/{ids}")
    public void deleteBuilding(@PathVariable List<Long> ids) {
        buildingService.removeBuilding(ids);
    }

    @GetMapping(value = "/{id}/staffs")
    public ResponseDTO getBuildingStaffAssignment(@PathVariable("id") Long buildingId) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(userService.getAssignedStaff(buildingId));
        responseDTO.setMessage("succeeded");
        return responseDTO;
    }

    @PutMapping("/staffs")
    public String assignStaffToBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
        assignmentBuildingService.assignStaffsToBuilding(assignmentBuildingDTO);
        return "succeeded";
    }
}


