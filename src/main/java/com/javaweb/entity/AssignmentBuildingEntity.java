package com.javaweb.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "assignmentbuilding")
@Getter
@Setter
public class AssignmentBuildingEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "buildingid")
    private BuildingEntity buildingEntity;

    @ManyToOne
    @JoinColumn(name = "staffid")
    private UserEntity userEntity;
}