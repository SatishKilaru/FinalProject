package com.insurance.Hospital.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.insurance.Hospital.models.Claim;
import com.insurance.Hospital.models.ClaimApplication;
import com.insurance.Hospital.models.ReUpload;
import com.insurance.Hospital.models.Uploads;
import com.insurance.Hospital.services.ClaimService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class InsuranceClaimController {

	ClaimService claimService;

	private HttpSession httpSession;

	@Autowired
	public InsuranceClaimController(ClaimService claimService, HttpSession httpSession) {
		this.claimService = claimService;
		this.httpSession = httpSession;
	}

	// New Claim

	@GetMapping(value = "/newclaim")
	public String newclaim(Model model) {
		return "SETCLAIMS";
	}

	@RequestMapping(value = "/claimbills", method = RequestMethod.POST)
	public String claimData(@RequestParam("file[]") MultipartFile[] files, Claim claim, ClaimApplication application,
			Model model) {
		return "index";
		// claimService.addClaimApplication(application);
		// claimService.addClaim(claim.getClamIplcId());
		// Claim clm_id = claimService.getClaimByid(claim.getClamIplcId());
		// int cid = clm_id.getClamId();
		// String uploadDir = "src/main/resources/static/file";
		//
		// try {
		// // Create the target directory if it doesn't exist
		// Files.createDirectories(Paths.get(uploadDir));
		//
		// for (MultipartFile file : files) {
		// // Get the original file name
		// String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		//
		// // Create the target file path within the directory
		// Path targetLocation = Paths.get(uploadDir).resolve(fileName);
		//
		// // Copy the file to the target location
		// Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		//
		// String fullPath = targetLocation.toAbsolutePath().toString();
		//
		// claimService.addClaimBills(file.getOriginalFilename(), fullPath, cid);
		//
		// }
		//
		// // After successfully storing all files, you can redirect to a success page or return a response accordingly
		// return "index";
		// } catch (IOException ex) {
		// ex.printStackTrace();
		//
		// }

	}

	@GetMapping(value = "/getFamilyMembers")
	public ResponseEntity<List<String>> getFamily(@RequestParam("policy") int id, Model model) {
		List<String> members = claimService.getFamilyByPolicy(id);
		return ResponseEntity.ok(members);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////

	// ListClaims

	@GetMapping(value = "/getAllClaims")
	public String getAllClaims(Model model) {
		System.out.println("madh");
		ArrayList<Claim> li = (ArrayList<Claim>) claimService.getAllClaims();
		System.out.println(li.size());
		model.addAttribute("claims", li);
		return "listclaims";
	}

	@PostMapping(value = "/viewClaim")
	public String getClaimById(Model model, @RequestParam("clamId") int clamId) {
		Claim cl = claimService.getClaimById(clamId);
		model.addAttribute("claim", cl);
		return "viewclaim";
	}

	@GetMapping(value = "/getFilteredClaims")
	public String getFilteredClaims(Model model, @RequestParam("status") String status) {
		System.out.println("madh");
		ArrayList<Claim> li = (ArrayList<Claim>) claimService.getFilteredClaims(status);
		System.out.println(li.size());
		model.addAttribute("claims", li);
		return "listclaims";
	}

	@RequestMapping(value = "/excel", method = RequestMethod.POST)
	public void downloadExcel(@RequestParam("selectedStatus") String status, HttpServletResponse response)
			throws IOException {
		ArrayList<Claim> Claims = new ArrayList<>();
		if (status == "select") {
			Claims = (ArrayList<Claim>) claimService.getAllClaims();
		} else {
			Claims = (ArrayList<Claim>) claimService.getFilteredClaims(status);
		}
		System.out.println(status + "Satish");

		// Create an Excel workbook using Apache POI
		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Claims Data");
		Row headerRow = sheet.createRow(0);

		// Define column headings
		headerRow.createCell(0).setCellValue("Claim_Id");
		headerRow.createCell(1).setCellValue("ClamSource");
		headerRow.createCell(2).setCellValue("ClamType");
		headerRow.createCell(3).setCellValue("ClamDate");
		headerRow.createCell(4).setCellValue("ClamAmountRequestedt");
		headerRow.createCell(5).setCellValue("ClamIplcId");
		headerRow.createCell(6).setCellValue("ClamProcessedAmount");
		headerRow.createCell(7).setCellValue("ClamProcessedDate");
		headerRow.createCell(8).setCellValue("ClamProcessedBy");
		headerRow.createCell(9).setCellValue("ClamRemarks");
		headerRow.createCell(10).setCellValue("ClamStatus");

		int rowIdx = 1;
		for (Claim claim : Claims) {
			Row row = sheet.createRow(rowIdx++);
			row.createCell(0).setCellValue(claim.getClamId());
			row.createCell(1).setCellValue(claim.getClamSource());
			row.createCell(2).setCellValue(claim.getClamType());
			row.createCell(3).setCellValue(claim.getClamDate());
			row.createCell(4).setCellValue(claim.getClamAmountRequested());
			row.createCell(5).setCellValue(claim.getClamIplcId());
			row.createCell(6).setCellValue(claim.getClamProcessedAmount());
			row.createCell(7).setCellValue(claim.getClamProcessedDate());
			row.createCell(8).setCellValue(claim.getClamProcessedBy());
			row.createCell(9).setCellValue(claim.getClamRemarks());
			row.createCell(10).setCellValue(claim.getClamStatus());

		}

		// Set the response headers for Excel download
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=claims.xlsx");

		// Write the Excel data to the response output stream
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.close();
	}
	
	//Upload
	
	@GetMapping(value = "/getrequired")
	public String getRequiredUploads(@RequestParam("claimid") int id, Model model) {
	    model.addAttribute("reupload", claimService.getAllReUploads(id));
	    model.addAttribute("claimid", id);
	    return "update";
	}


	@PostMapping(value = "/adduploads")
	public String addUploads(@RequestParam("claimid") String id, MultipartHttpServletRequest request,Model model) {

		int claimId = Integer.parseInt(id);
		int index = 1;

		List<ReUpload> list = claimService.getAllReUploads(claimId);
		List<Uploads> list2 = claimService.getAllUploads(claimId);
		
		if(list2.size()>0) {
		
			index=list2.get(list2.size()).getReUploadId();
		}
		for (ReUpload upload : list) {
			if (upload.getClaimId() == claimId) {
				String name = upload.getName();
				System.out.println(claimId);
				MultipartFile file = request.getFile(name);
				if (file != null && !file.isEmpty()) {
					System.out.println(name);
					if (upload.getType().equals("file")) {
						System.out.println("file");

						String uploadDir = "src/main/resources/static/file";
						try {
							Files.createDirectories(Paths.get(uploadDir));

							String fileName = StringUtils.cleanPath(file.getOriginalFilename());
							Path targetLocation = Paths.get(uploadDir).resolve(fileName);
							Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
							String fullPath = targetLocation.toAbsolutePath().toString();

							Uploads up = new Uploads();
							up.setUploadId(index);
							up.setReUploadId(upload.getUploadId());
							up.setClaimId(claimId);
							up.setData(fullPath);
							up.setType("file");

							claimService.addUploads(up);

						} catch (IOException ex) {
							ex.printStackTrace();
						}
					} else {

						Uploads up = new Uploads();

						up.setUploadId(index);
						up.setReUploadId(upload.getUploadId());
						up.setClaimId(claimId);
						up.setData(file.getOriginalFilename());
						up.setType("text");

						claimService.addUploads(up);
					}
				}
			}
		}

		model.addAttribute("claimid", claimId);
		return "update";
	}
}