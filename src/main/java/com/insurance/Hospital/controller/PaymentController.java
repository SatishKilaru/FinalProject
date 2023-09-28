package com.insurance.Hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.insurance.Hospital.contractors.PaymentRepoInterface;
import com.insurance.Hospital.models.Payments;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {

	PaymentRepoInterface pri;

	@Autowired
	public PaymentController(PaymentRepoInterface pri, HttpSession httpSession) {
		this.pri = pri;
	}

	@GetMapping("/payments")
	public String displayPayments(Model model) {
		List<Payments> payments = pri.getPayments();
		model.addAttribute("payments", payments);
		return "payments";
	}

	@GetMapping("/view")
	public String viewPayment(@RequestParam("id") String SettlementId, Model model) {
		System.out.println(Integer.parseInt(SettlementId));

		Payments payment = pri.getPaymentById(Integer.parseInt(SettlementId));
		model.addAttribute("payment", payment);
		return "paymentDetails";
	}

	@GetMapping("/search")
	public String searchPaymentsByPaymentId(@RequestParam("filterBy") String type, @RequestParam("value") String value,
			Model model) {
		System.out.println(value + type);

		List<Payments> filteredData = pri.filterList(type, value);
		model.addAttribute("payments", filteredData);
		return "payments";
	}
}
