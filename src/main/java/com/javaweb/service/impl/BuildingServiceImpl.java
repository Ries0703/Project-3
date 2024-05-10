package com.javaweb.service.impl;

import com.javaweb.converter.BuildingConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.StringUtil;
import com.javaweb.utils.UploadFileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements IBuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private BuildingConverter buildingConverter;
    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Override
    public int getBuildingCount(BuildingSearchRequest buildingSearchRequest) {
        return buildingRepository.count(buildingSearchRequest);
    }

    @Override
    public List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest, Pageable pageable) {
        return buildingRepository.findAll(buildingSearchRequest, pageable).stream().map(buildingConverter::entityToResponse).collect(Collectors.toList());
    }

    @Override
    public BuildingDTO findById(Long id) {
        Optional<BuildingEntity> buildingEntity = buildingRepository.findById(id);
        if (!buildingEntity.isPresent()) {
            return new BuildingDTO();
        }
        return buildingConverter.entityToDto(buildingEntity.get());
    }

    @Override
    public void addOrEditBuilding(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity;
        boolean isEditBuilding = !StringUtil.isEmpty(buildingDTO.getId());
        if (isEditBuilding) {
            buildingEntity = buildingRepository.findById(buildingDTO.getId()).get();
        } else {
            buildingEntity = new BuildingEntity();
        }
        buildingEntity = buildingConverter.dtoToEntity(buildingDTO, buildingEntity);
        saveThumbnail(buildingDTO, buildingEntity);
        buildingRepository.save(buildingEntity);
    }

    private void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        String path = "/building/" + buildingDTO.getImageName();
        if (null != buildingDTO.getImageBase64()) {
            if (null != buildingEntity.getImage()) {
                if (!path.equals(buildingEntity.getImage())) {
                    File file = new File("C:/home/office" + buildingEntity.getImage());
                    file.delete();
                }
            }
            byte[] bytes = Base64.decodeBase64(buildingDTO.getImageBase64().getBytes());
            UploadFileUtils.writeOrUpdate(path, bytes);
            buildingEntity.setImage(path);
        }
    }

    @Override
    public void removeBuilding(List<Long> ids) {
        buildingRepository.deleteByIdIn(ids);
    }
}