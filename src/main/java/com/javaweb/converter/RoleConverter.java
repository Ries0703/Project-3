package com.javaweb.converter;

import com.javaweb.model.dto.RoleDTO;
import com.javaweb.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public RoleDTO convertToDto(RoleEntity entity) {
        return modelMapper.map(entity, RoleDTO.class);
    }
}
