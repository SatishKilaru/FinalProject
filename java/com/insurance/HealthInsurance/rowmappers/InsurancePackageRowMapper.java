package com.insurance.HealthInsurance.rowmappers;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.HealthInsurance.models.InsurancePackage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InsurancePackageRowMapper implements RowMapper<InsurancePackage> {

    @Override
    public InsurancePackage mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        InsurancePackage insurancePackage = new InsurancePackage();
        insurancePackage.setInspId(resultSet.getInt(1));
        insurancePackage.setInspTitle(resultSet.getString(2));
        insurancePackage.setInspDescription(resultSet.getString(3));
        insurancePackage.setInspStatus(resultSet.getString(4));
        insurancePackage.setInspRangeStart(resultSet.getDouble(5));
        insurancePackage.setInspRangeEnd(resultSet.getDouble(6));
        insurancePackage.setInspAgeLimitStart(resultSet.getInt(7));
        insurancePackage.setInspAgeLimitEnd(resultSet.getInt(8));
        return insurancePackage;
    }
}
