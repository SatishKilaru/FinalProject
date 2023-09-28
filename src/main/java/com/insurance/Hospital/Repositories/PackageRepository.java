package com.insurance.Hospital.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.Hospital.contractors.PackageDaoInterface;
import com.insurance.Hospital.contractors.PackageRepoInterface;
import com.insurance.Hospital.models.DiseaseDetails;
import com.insurance.Hospital.models.InsurancePackage;
import com.insurance.Hospital.models.InsurancePackageCoveredDisease;

@Repository
public class PackageRepository implements PackageRepoInterface {

	@Autowired
	PackageDaoInterface padi;

	@Override
	public List<InsurancePackage> getAllInsurancePackages() {

		return padi.getAllInsurancePackages();
	}

	@Override
	public List<InsurancePackageCoveredDisease> getCoveredDiseasesByPackageId(int packageId) {

		return padi.getCoveredDiseasesByPackageId(packageId);
	}

	@Override
	public DiseaseDetails getDetailsByDiseaseId(int discId) {

		return padi.getDetailsByDiseaseId(discId);
	}

	@Override
	public List<InsurancePackage> getFiteredDiseases(String status, int age) {

		return padi.getFiteredDiseases(status, age);
	}

	@Override
	public List<InsurancePackage> getPackagesByStatus(String status) {

		return padi.getPackagesByStatus(status);
	}

	@Override
	public List<InsurancePackage> getAllInsurancePackagesByAge(int age) {

		return padi.getAllInsurancePackagesByAge(age);
	}

	@Override
	public List<DiseaseDetails> getDiseasesByPackageId(int inspId) {

		return padi.getDiseasesByPackageId(inspId);
	}

}
