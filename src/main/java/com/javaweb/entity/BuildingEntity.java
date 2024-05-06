package com.javaweb.entity;


import com.javaweb.enums.DistrictCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "building")
@Getter
@Setter
public class BuildingEntity extends BaseEntity {
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "ward")
    private String ward;

    @Column(name = "district")
    private String districtCode;

    @Column(name = "numberofbasement")
    private Long numberOfBasement;

    @Column(name = "floorarea")
    private Long floorArea;

    @Column(name = "level")
    private Long level;


    @Column(name = "type")
    private String type;

    @Column(name = "structure")
    private String structure;




    @Column(name = "direction")
    private String direction;



    @Column(name = "rentprice", nullable = false)
    private Long rentPrice;

    @Column(name = "rentpricedescription")
    private String rentPriceDescription;

    @Column(name = "servicefee")
    private String serviceFee;

    @Column(name = "carfee")
    private String carFee;

    @Column(name = "motofee")
    private String motorbikeFee;

    @Column(name = "overtimefee")
    private String overtimeFee;

    @Column(name = "waterfee")
    private String waterFee;

    @Column(name = "electricityfee")
    private String electricityFee;

    @Column(name = "deposit")
    private String deposit;

    @Column(name = "payment")
    private String payment;

    @Column(name = "renttime")
    private String rentTime;

    @Column(name = "decorationtime")
    private String decorationTime;

    @Column(name = "brokeragefee")
    private Double brokerageFee;

    @Column(name = "note")
    private String note;

    @Column(name = "linkofbuilding")
    private String linkOfBuilding;

    @Column(name = "map")
    private String map;

    @Column(name = "avatar")
    private String image;

    @Column(name = "managername")
    private String managerName;

    @Column(name = "managerphone")
    private String managerPhoneNumber;

    @OneToMany(mappedBy = "buildingEntity")
    private List<RentAreaEntity> rentAreaEntities;

    @OneToMany(mappedBy = "buildingEntity")
    private List<AssignmentBuildingEntity> assignmentBuildingEntities;
}