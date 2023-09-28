package com.insurance.Hospital.contractors;

import java.util.List;

import com.insurance.Hospital.models.DiseaseDetails;
import com.insurance.Hospital.models.InsurancePackage;
import com.insurance.Hospital.models.InsurancePackageCoveredDisease;

public interface PackageRepoInterface {

	List<InsurancePackage> getAllInsurancePackages();

	List<InsurancePackageCoveredDisease> getCoveredDiseasesByPackageId(int packageId);

	DiseaseDetails getDetailsByDiseaseId(int discId);

	List<InsurancePackage> getFiteredDiseases(String status, int age);

	List<InsurancePackage> getPackagesByStatus(String status);

	List<InsurancePackage> getAllInsurancePackagesByAge(int age);

	List<DiseaseDetails> getDiseasesByPackageId(int inspId);
}
