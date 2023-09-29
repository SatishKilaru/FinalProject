package com.insurance.Hospital.rowmappers;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.Hospital.models.Uploads;

public class UploadsRowMapper implements RowMapper<Uploads> {

    @Override
    public Uploads mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Uploads uploads = new Uploads();
        uploads.setUploadId(resultSet.getInt("uploadId"));
        uploads.setReUploadId(resultSet.getInt("reUploadId"));
        uploads.setClaimId(resultSet.getInt("claimId"));
        uploads.setData(resultSet.getString("data"));
        uploads.setType(resultSet.getString("type"));
        return uploads;
    }
}
