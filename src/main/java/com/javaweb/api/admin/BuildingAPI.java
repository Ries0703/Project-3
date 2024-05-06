package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/buildings")
public class BuildingAPI {
    @DeleteMapping(value = "/{ids}")
    public void deleteBuilding(@PathVariable Long[] ids) {
        System.out.println("ids gathered");
    }

    @PostMapping
    public String addBuilding(@RequestBody BuildingDTO building) {
        return "addBuilding()";
    }

    @PutMapping
    public void editBuilding(@RequestBody BuildingDTO building) {
        System.out.println("updated the building chat");
    }

    @GetMapping(value = "/{id}/staffs")
    public ResponseDTO getBuildingStaffAssignment(@PathVariable("id") Long buildingId) {
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setStaffId((long) i);
            staffResponseDTO.setChecked(i % 2 == 0 ? "" : "checked");
            staffResponseDTO.setFullName("Staff No." + i);
            staffResponseDTOS.add(staffResponseDTO);
        }
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(staffResponseDTOS);
        responseDTO.setMessage("succeeded");
        return responseDTO;
    }

    @PutMapping("/assign")
    public ResponseDTO assignStaffToBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Assigning Succeeded");
        return responseDTO;
    }
}