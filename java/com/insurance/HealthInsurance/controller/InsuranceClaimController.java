package com.insurance.HealthInsurance.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.HealthInsurance.models.Claim;
import com.insurance.HealthInsurance.models.ClaimBills;
import com.insurance.HealthInsurance.models.Claims;
import com.insurance.HealthInsurance.models.Claimsss;
import com.insurance.HealthInsurance.models.DiseaseDetails;
import com.insurance.HealthInsurance.models.InsurancePackage;
import com.insurance.HealthInsurance.models.InsurancePackageCoveredDisease;
import com.insurance.HealthInsurance.models.LoginClass;
import com.insurance.HealthInsurance.models.OTPclass;
import com.insurance.HealthInsurance.models.Payments;
import com.insurance.HealthInsurance.services.ClaimService;

import jakarta.servlet.http.HttpServletRequest;
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

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String addCalim() {

		return "dashboard";
	}

	@RequestMapping(value = "/dash", method = RequestMethod.GET)
	public String dashboard() {
		return "HospitalDashboard";
	}

	@RequestMapping(value = "/apply-claim", method = RequestMethod.POST)
	public String claimData(@RequestParam("file") MultipartFile file, Claim claim, Model model) {

		Path path = Paths.get("C:\\Users\\Ajay kumar\\OneDrive\\Desktop\\", file.getOriginalFilename());

		if (!Files.exists(path)) {
			model.addAttribute("message", "File not found.");
			return "claim";
		}

		try {
			byte[] bytes = file.getBytes();
			Files.write(path, bytes);

			String filePath = path.toString();
			claim.setDocumentPath(filePath);

		} catch (IOException e) {
			e.printStackTrace();

		}

		claimService.addClaim(claim);

		return "success";
	}

	@GetMapping("/start")
	public String getAllInsurancePackages(Model model) {
		List<InsurancePackage> insurancePackages = claimService.getAllInsurancePackages();

		model.addAttribute("insurancePackages", insurancePackages);

		return "packages";
	}

	@GetMapping("/view-insurance/{inspId}")
	public String viewInsurance(@PathVariable int inspId, Model model) {

		List<InsurancePackageCoveredDisease> coveredDiseases = claimService.getCoveredDiseasesByPackageId(inspId);

		model.addAttribute("coveredDiseases", coveredDiseases);

		return "insurance-package-view";
	}

	@GetMapping("/diseasedetails/{discId}")
	public String viewDiseseDetails(@PathVariable int discId, Model model) {
		DiseaseDetails dd = claimService.getDiseaseDetailsById(discId);
		model.addAttribute("diseasedetails", dd);
		System.out.println("age1");
		return "diseasedetails";

	}
//
//	@RequestMapping(value = "/start")
//	public String packages() {
//		return "redirect:/list";
//
//	}

	@GetMapping("/filteredpackages")
	public String getFilteredPackages(@RequestParam("status") String status, @RequestParam("age") String age,
			Model model) {
		System.out.println(status);
		if ("ALL".equals(status) && age.equals("")) {
			System.out.println("if");
			List<InsurancePackage> insurancePackages = claimService.getAllInsurancePackages();

			System.out.println(insurancePackages);
			model.addAttribute("insurancePackages", insurancePackages);

			return "packages";
		} else if ("ALL".equals(status) && !age.equals("")) {
			System.out.println("if");
			List<InsurancePackage> insurancePackages = claimService.getAllInsurancePackagesByAge(Integer.parseInt(age));

			System.out.println(insurancePackages);
			model.addAttribute("insurancePackages", insurancePackages);

			return "packages";
		} else {

			if (age.equals("")) {
				List<InsurancePackage> insurancePackages = claimService.getPackagesByStatus(status);
				model.addAttribute("insurancePackages", insurancePackages);
				return "packages";
			} else {
				List<InsurancePackage> packages = claimService.getFilteredPackages(status, Integer.parseInt(age));
				model.addAttribute("insurancePackages", packages);
				System.out.println(packages);
				System.out.println(age);

				return "packages";

			}
		}

	}

	@RequestMapping(value = "/claimdash", method = RequestMethod.GET)
	public String ClaimApplicants() {

		return "hell";
	}

	////
	////
	// Login Controller

	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("login", new LoginClass());
		return "login";
	}

	@GetMapping("/forgotpassword")
	public String forgotpassword(Model model) {
		model.addAttribute("to", "");
		model.addAttribute("login", new OTPclass());
		model.addAttribute("enotp", "");
		model.addAttribute("otp", "");

		return "forgotpassword";
	}

	// check credentials
	@PostMapping("/adminLogin")
	public String adminlogin(HttpServletRequest request, @ModelAttribute("login") LoginClass lc, Model model) {

		int check = claimService.checkCredentials(lc);
		if (check == 1) {
			// model.addAttribute("hospitalCount", claimService.getHospitalsCount());
			// model.addAttribute("packageCount", claimService.getPackagesCount());
			return "index";
		}

		model.addAttribute("user_name", "lc.getUser_name()");
		model.addAttribute("password", "lc.getPassword()");
		model.addAttribute("errorMessage", "incorrect credentials");
		return "login";
	}

	@GetMapping("/email")
	@ResponseBody
	public String email(@RequestParam("to") String to_mail) {
		String email = to_mail;
		httpSession.setAttribute("email", email);
		// storing generated otp
		int OTP = claimService.sendmail(to_mail);
		httpSession.setAttribute("OTP", OTP);

		return "Email Sent Successfully";

	}

	@PostMapping(value = "/validateOTP")
	public ModelAndView validateOTP(@RequestParam("otp") String otp, Model model) {
		model.addAttribute("to", "");
		int OTP = Integer.parseInt(otp);
		ModelAndView mav = new ModelAndView();
		int originalOtp = (Integer) httpSession.getAttribute("OTP");
		String email = (String) httpSession.getAttribute("email");
		// checking the otp sent by the user if true returning reset page else need to stay in the same page with error
		// msg
		if (originalOtp == OTP) {
			mav.setViewName("reset");
			mav.addObject("email", email);
			return mav;
		}
		mav.setViewName("forgotPassword");
		mav.addObject("msg", "Please Enter Valid OTP");
		mav.addObject("email", email);
		return mav;
	}

	@PostMapping("/reset")
	public String reset(Model model, @RequestParam("email") String email, @RequestParam("pwd") String pwd,
			@RequestParam("cnfpwd") String cnfpwd) {
		System.out.println(email + " " + pwd + " " + cnfpwd);
		int x = claimService.resetpwd(email, pwd);
		if (x == 1)
			model.addAttribute("message", "password changed");
		else
			model.addAttribute("message", "error while password changing");
		model.addAttribute("login", new LoginClass());
		return "login";
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////

	// ListClaims
	// Get all books
	@GetMapping(value = "/getAllClaims")
	public String getAllClaims(Model model) {

		ArrayList<Claims> li = (ArrayList<Claims>) claimService.getAllClaims();
		System.out.println(li.size());
		model.addAttribute("claims", li);
		return "listclaims";
	}

	@PostMapping(value = "/viewClaim")
	public String getClaimById(Model model, @RequestParam("clamId") int clamId) {
		Claims cl = claimService.getClaimById(clamId);
		model.addAttribute("claim", cl);
		return "viewclaim";
	}

	@GetMapping(value = "/getFilteredClaims")
	public String getFilteredClaims(Model model, @RequestParam("status") String status) {

		ArrayList<Claims> li = (ArrayList<Claims>) claimService.getFilteredClaims(status);
		System.out.println(li.size());
		model.addAttribute("claims", li);
		return "claims";
	}

	@RequestMapping(value = "/excel", method = RequestMethod.POST)
	public void downloadExcel(@RequestParam("selectedStatus") String status, HttpServletResponse response)
			throws IOException {
		ArrayList<Claims> Claims = new ArrayList<>();
		if (status == "select") {
			Claims = (ArrayList<Claims>) claimService.getAllClaims();
		} else {
			Claims = (ArrayList<Claims>) claimService.getFilteredClaims(status);
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
		for (Claims claim : Claims) {
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
		response.setHeader("Content-Disposition", "attachment; filename=employees.xlsx");

		// Write the Excel data to the response output stream
		OutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		outputStream.close();
	}
	//////////////////
	
	//DashBoard
	
	@RequestMapping(value = "/applicants", method = RequestMethod.GET)
	public String getDashBoard(Model model) {
		List<Claims> claims = claimService.getAllApplicants();
		model.addAttribute("claims", claims);

		List<Claims> claimsunderprocess = claimService.getAllClaimss();
		model.addAttribute("claimsunderprocess", claimsunderprocess);

		return "hell";

	}

	@RequestMapping(value = "/rejected", method = RequestMethod.GET)
	public String getAllRejectedLoans(Model model) {
		List<ClaimBills> claimbills = claimService.getRejectedLoans();
		model.addAttribute("rejectedbills", claimbills);

		return "rejected";
	}

	
	@RequestMapping(value = "/claims", method = RequestMethod.GET)
	public String getClaimedValue(Model model) {
		List<ClaimBills> amtRecived = claimService.getClaimedAmount();
		model.addAttribute("claimedamt", amtRecived);

		List<ClaimBills> totalAmt = claimService.getClaimedAmount();
		model.addAttribute("total_amount", totalAmt);

		return "claimvalue";
	}
	/////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	///////////////////
	
	
	///payments
	
	
	@GetMapping("/payments")
    public String displayPayments(Model model) {
        List<Payments> payments = claimService.getPayments();
        model.addAttribute("payments", payments);
        return "payments";
    }
	
	@GetMapping("/view/{paymentId}")
	public String viewPayment(@PathVariable String paymentId, Model model) {
	    Payments payment = claimService.getPaymentById(paymentId);
	    model.addAttribute("payment", payment);
	    return "paymentDetails"; 
	}
}
