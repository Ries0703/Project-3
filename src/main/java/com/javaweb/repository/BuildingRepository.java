package com.javaweb.repository;



import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
	@Transactional
	void deleteByIdIn(Long[] id);
}
