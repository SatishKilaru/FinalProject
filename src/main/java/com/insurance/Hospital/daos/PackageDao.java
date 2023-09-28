package com.insurance.Hospital.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.insurance.Hospital.contractors.PackageDaoInterface;
import com.insurance.Hospital.models.DiseaseDetails;
import com.insurance.Hospital.models.InsurancePackage;
import com.insurance.Hospital.models.InsurancePackageCoveredDisease;
import com.insurance.Hospital.rowmappers.DiseseDetailsRowMapper;
import com.insurance.Hospital.rowmappers.InsurancePackageCoveredDiseaseRowMapper;
import com.insurance.Hospital.rowmappers.InsurancePackageRowMapper;

@Component
public class PackageDao implements PackageDaoInterface {

	private static final String GET_INSURANCE_PACKAGES = "SELECT * FROM InsurancePackages";
	private static final String GET_COVERED_DISEASES_BY_PACKAGE_ID = "SELECT * FROM InsurancePackageCoveredDiseases WHERE insp_id = ?";
	private static final String GET_DISEASE_DETAILS_BY_DISEASE_ID = "select * from Diseases where disc_id=?";
	private static final String GET_FILTERED_PACKAGES = "select * FROM InsurancePackages where insp_status=? and ? BETWEEN insp_agelimit_start AND insp_agelimit_end;";
	private static final String GET_PACKAGES_BY_STATUS = "select * FROM InsurancePackages where insp_status=?";
	private static final String GET_FILTERED_PACKAGES_BY_AGE = "select * FROM InsurancePackages where ? BETWEEN insp_agelimit_start AND insp_agelimit_end;";
	private static final String GET_DISEASE_DETAILS_BY_PACKAGE_ID = "SELECT D.* FROM Diseases AS D JOIN InsurancePackageCoveredDiseases AS IPCD ON D.disc_id = IPCD.disc_id JOIN InsurancePackages AS IP ON IPCD.insp_id = IP.insp_id WHERE IP.insp_id = ?;";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<InsurancePackage> getAllInsurancePackages() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_INSURANCE_PACKAGES, new InsurancePackageRowMapper());
	}

	public List<InsurancePackageCoveredDisease> getCoveredDiseasesByPackageId(int packageId) {
		return jdbcTemplate.query(GET_COVERED_DISEASES_BY_PACKAGE_ID, new Object[] { packageId },
				new InsurancePackageCoveredDiseaseRowMapper());
	}

	@Override
	public DiseaseDetails getDetailsByDiseaseId(int discId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(GET_DISEASE_DETAILS_BY_DISEASE_ID, new Object[] { discId },
				new DiseseDetailsRowMapper());
	}

	@Override
	public List<InsurancePackage> getFiteredDiseases(String status, int age) {
		// TODO Auto-generated method stub
		System.out.println("dao" + status + age);
		// System.out.println(jdbcTemplate.query("select * FROM InsurancePackages", values, new
		// InsurancePackageRowMapper()));
		return jdbcTemplate.query(GET_FILTERED_PACKAGES, new Object[] { status, age }, new InsurancePackageRowMapper());
	}

	@Override
	public List<InsurancePackage> getPackagesByStatus(String status) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_PACKAGES_BY_STATUS, new Object[] { status }, new InsurancePackageRowMapper());
	}

	@Override
	public List<InsurancePackage> getAllInsurancePackagesByAge(int age) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_FILTERED_PACKAGES_BY_AGE, new Object[] { age }, new InsurancePackageRowMapper());
	}

	@Override
	public List<DiseaseDetails> getDiseasesByPackageId(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_DISEASE_DETAILS_BY_PACKAGE_ID, new Object[] { id }, new DiseseDetailsRowMapper());

	}

}
