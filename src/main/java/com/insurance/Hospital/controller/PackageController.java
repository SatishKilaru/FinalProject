package com.insurance.Hospital.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.insurance.Hospital.contractors.PackageRepoInterface;
import com.insurance.Hospital.models.DiseaseDetails;
import com.insurance.Hospital.models.InsurancePackage;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PackageController {

	PackageRepoInterface packageri;

	public PackageController(PackageRepoInterface packageri) {
		this.packageri = packageri;
	}

	@GetMapping("/start")
	public String getAllInsurancePackages(Model model) {
		List<InsurancePackage> insurancePackages = packageri.getAllInsurancePackages();

		model.addAttribute("insurancePackages", insurancePackages);

		return "packages";
	}

	@GetMapping("/filteredpackages")
	public String getFilteredPackages(@RequestParam("status") String status, @RequestParam("age") String age,
			Model model) {
		System.out.println(status);
		if ("ALL".equals(status) && age.equals("")) {
			System.out.println("if");
			List<InsurancePackage> insurancePackages = packageri.getAllInsurancePackages();

			System.out.println(insurancePackages);
			model.addAttribute("insurancePackages", insurancePackages);

			return "packages";
		} else if ("ALL".equals(status) && !age.equals("")) {
			System.out.println("if");
			List<InsurancePackage> insurancePackages = packageri.getAllInsurancePackagesByAge(Integer.parseInt(age));

			System.out.println(insurancePackages);
			model.addAttribute("insurancePackages", insurancePackages);

			return "packages";
		} else {

			if (age.equals("")) {
				List<InsurancePackage> insurancePackages = packageri.getPackagesByStatus(status);
				model.addAttribute("insurancePackages", insurancePackages);
				return "packages";
			} else {
				List<InsurancePackage> packages = packageri.getFiteredDiseases(status, Integer.parseInt(age));
				model.addAttribute("insurancePackages", packages);
				System.out.println(packages);
				System.out.println(age);

				return "packages";

			}
		}

	}

	@RequestMapping(value = "/excel")
	public void downloadExcel(@RequestParam("status") String status, @RequestParam("age") String age,
			HttpServletResponse response) throws IOException {
		List<InsurancePackage> insurancePackages = new ArrayList<>();
		System.out.println(status + age);

		if ("ALL".equals(status) && age.equals("")) {
			System.out.println("if");
			insurancePackages = packageri.getAllInsurancePackages();

		} else if ("ALL".equals(status) && !age.equals("")) {
			System.out.println("if");
			insurancePackages = packageri.getAllInsurancePackagesByAge(Integer.parseInt(age));

			// Add the data to the model for rendering in the Thymeleaf template

		} else {

			if (age.equals("")) {
				insurancePackages = packageri.getPackagesByStatus(status);

			} else {
				insurancePackages = packageri.getFiteredDiseases(status, Integer.parseInt(age));

			}
		}
		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Packages List");
		Row headerRow = sheet.createRow(0);

		// Define column headings
		headerRow.createCell(0).setCellValue("PackageId");
		headerRow.createCell(1).setCellValue("PackageTitle");
		headerRow.createCell(2).setCellValue("Discription");
		headerRow.createCell(3).setCellValue("Status");
		headerRow.createCell(4).setCellValue("Amount Start Range");
		headerRow.createCell(5).setCellValue("Amount End Range");
		headerRow.createCell(6).setCellValue("Age Limit Start");
		headerRow.createCell(7).setCellValue("Age Limit End");

		System.out.println(insurancePackages.size());

		int rowIdx = 1;
		for (InsurancePackage insurance : insurancePackages) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(insurance.getInspId());
			row.createCell(1).setCellValue(insurance.getInspTitle());
			row.createCell(2).setCellValue(insurance.getInspDescription());
			row.createCell(3).setCellValue(insurance.getInspStatus());
			row.createCell(4).setCellValue(insurance.getInspRangeStart());
			row.createCell(5).setCellValue(insurance.getInspRangeEnd());
			row.createCell(6).setCellValue(insurance.getInspAgeLimitStart());
			row.createCell(7).setCellValue(insurance.getInspAgeLimitEnd());

		}

		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=packages.xlsx");
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.close();
	}

	@GetMapping(value = "/diseases/{inspId}")
	public String getDiseases(@PathVariable int inspId, Model model) {
		List<DiseaseDetails> diseases = packageri.getDiseasesByPackageId(inspId);
		System.out.println("jhjhjh" + inspId);
		int insId = inspId;
		model.addAttribute("inspId", insId);
		model.addAttribute("diseases", diseases);
		return "diseasedetails";

	}

}
