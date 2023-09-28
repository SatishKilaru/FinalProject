package com.insurance.Hospital.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.Hospital.contractors.DashboardRepositoryInterface;
import com.insurance.Hospital.models.ClaimBills;
import com.insurance.Hospital.models.claimss;

@Controller
public class DashboardController {

	DashboardRepositoryInterface dashboard;

	public DashboardController(DashboardRepositoryInterface dashboard) {
		this.dashboard = dashboard;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getDashBoard() {
		return "index";
	}

	@RequestMapping(value = "/applicants", method = RequestMethod.GET)
	public String getAllApplicants(Model model) {
		List<claimss> claims = dashboard.getAllApplicants();
		model.addAttribute("claims", claims);

		List<claimss> claimsunderprocess = dashboard.getAllClaimss();
		model.addAttribute("claimsunderprocess", claimsunderprocess);

		return "applicants";

	}

	@RequestMapping(value = "/rejected", method = RequestMethod.GET)
	public String getAllRejectedLoans(Model model) {
		List<ClaimBills> claimbills = dashboard.getRejectedLoans();
		model.addAttribute("rejectedbills", claimbills);

		return "rejected";
	}

	@RequestMapping(value = "/claims", method = RequestMethod.GET)
	public String getClaimedValue(Model model) {
		List<ClaimBills> amtRecived = dashboard.getClaimedAmount();
		model.addAttribute("claimedamt", amtRecived);

		List<ClaimBills> totalAmt = dashboard.getTotalAmount();
		model.addAttribute("total_amount", totalAmt);

		return "claimvalue";
	}

}
