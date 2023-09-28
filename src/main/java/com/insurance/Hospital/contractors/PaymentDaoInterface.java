package com.insurance.Hospital.contractors;

import java.util.List;

import com.insurance.Hospital.models.Payments;

public interface PaymentDaoInterface {

	List<Payments> getPayments();

	Payments getPaymentById(int paymentId);

	List<Payments> filterList(String type, String value);
}
