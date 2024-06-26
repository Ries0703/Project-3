package com.javaweb.repository.custom.impl;


import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.custom.BuildingRepositoryCustom;

import com.javaweb.utils.StringUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuildingRepositoryCustomImpl implements BuildingRepositoryCustom {
    private static final List<String> LIKE_FIELDS = Arrays.asList("name", "ward", "street", "direction", "level", "managerName", "managerPhoneNumber");
    private static final List<String> EQUAL_FIELDS = Arrays.asList("floorArea", "districtId", "numberOfBasement");
    private static final String STAFF_ID_FIELD = "staffId";


    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<BuildingEntity> findAll(BuildingSearchRequest buildingSearch) {
        // build SQL query
        StringBuilder select = new StringBuilder("SELECT ");
        StringBuilder distinct = new StringBuilder();
        String columns = "  b.* FROM building b ";
        StringBuilder join = new StringBuilder();
        StringBuilder where = new StringBuilder(" WHERE 1 = 1");
        sqlWhereSimple(buildingSearch, where);
        sqlWhereComplex(buildingSearch, where);
        sqlJoin(buildingSearch, join);
        if (!StringUtil.isEmpty(join)) {
            distinct.append(" DISTINCT ");
        }
        String sql = select.append(distinct).append(columns).append(join).append(where).toString();

        // get results
        return entityManager.createNativeQuery(sql, BuildingEntity.class).getResultList();
    }

    private void sqlWhereSimple(BuildingSearchRequest buildingSearch, StringBuilder where) {
        try {
            for (Field field : BuildingSearchRequest.class.getDeclaredFields()) {
                field.setAccessible(true);
                String key = field.getName();
                Object value = field.get(buildingSearch);
                if (StringUtil.isEmpty(value)) {
                    continue;
                }
                if (LIKE_FIELDS.contains(key)) {
                    where.append(" AND b.").append(key).append(" LIKE '%").append(value.toString().trim()).append("%' ");
                } else if (EQUAL_FIELDS.contains(key)) {
                    where.append(" AND b.").append(key).append(" = ").append(value);
                } else if (STAFF_ID_FIELD.equals(key)) {
                    where.append(" AND asb.staffid = ").append(value);
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private void sqlWhereComplex(BuildingSearchRequest buildingSearch, StringBuilder where) {
        if (!StringUtil.isEmpty(buildingSearch.getRentPriceFrom())) {
            where.append(" AND b.rentprice >= ").append(buildingSearch.getRentPriceFrom());
        }

        if (!StringUtil.isEmpty(buildingSearch.getRentPriceTo())) {
            where.append(" AND b.rentprice <= ").append(buildingSearch.getRentPriceTo());
        }

        if (!StringUtil.isEmpty(buildingSearch.getAreaFrom())) {
            where.append(" AND ra.value >= ").append(buildingSearch.getAreaFrom());
        }

        if (!StringUtil.isEmpty(buildingSearch.getAreaTo())) {
            where.append(" AND ra.value <= ").append(buildingSearch.getAreaTo());
        }

        if (StringUtil.usableTypeCode(buildingSearch.getTypeCode())) {
            String type = buildingSearch.getTypeCode().stream().map(code -> "'" + code.toString().trim() + "'").collect(Collectors.joining(", "));
            where.append(" AND rt.code IN (").append(type).append(") ");
        }
    }

    private void sqlJoin(BuildingSearchRequest buildingSearch, StringBuilder join) {
        if (!StringUtil.isEmpty(buildingSearch.getStaffId())) {
            join.append(" JOIN assignmentbuilding asb ON b.id = asb.buildingid");
        }
        if (!StringUtil.isEmpty(buildingSearch.getAreaFrom()) || !StringUtil.isEmpty(buildingSearch.getAreaTo())) {
            join.append(" JOIN rentarea ra ON b.id = ra.buildingid");
        }
        if (StringUtil.usableTypeCode(buildingSearch.getTypeCode())) {
            join.append(" JOIN buildingrenttype brt ON brt.buildingid = b.id JOIN renttype rt ON brt.renttypeid = rt.id");
        }
    }
}
