package com.javaweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Table(name = "rentarea")
@Entity
public class RentAreaEntity extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name = "buildingid")
	private BuildingEntity buildingEntity;

	@Column(name = "value")
	private Integer value;
}
