package com.insurance.Hospital.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.Hospital.contractors.PaymentDaoInterface;
import com.insurance.Hospital.contractors.PaymentRepoInterface;
import com.insurance.Hospital.models.Payments;

@Repository
public class PaymentRepo implements PaymentRepoInterface {

	@Autowired
	PaymentDaoInterface pdi;

	@Override
	public List<Payments> getPayments() {

		return pdi.getPayments();
	}

	@Override
	public Payments getPaymentById(int paymentId) {
		return pdi.getPaymentById(paymentId);
	}

	@Override
	public List<Payments> filterList(String type, String value) {
		return pdi.filterList(type, value);
	}

}
