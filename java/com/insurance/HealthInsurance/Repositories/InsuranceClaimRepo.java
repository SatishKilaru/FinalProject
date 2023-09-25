package com.insurance.HealthInsurance.Repositories;

import java.util.ArrayList;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import com.insurance.HealthInsurance.contractors.InsuranceClaim;
import com.insurance.HealthInsurance.models.Claim;
import com.insurance.HealthInsurance.models.ClaimBills;
import com.insurance.HealthInsurance.models.Claims;
import com.insurance.HealthInsurance.models.Claimsss;
import com.insurance.HealthInsurance.models.DiseaseDetails;
import com.insurance.HealthInsurance.models.InsurancePackage;
import com.insurance.HealthInsurance.models.InsurancePackageCoveredDisease;
import com.insurance.HealthInsurance.models.LoginClass;
import com.insurance.HealthInsurance.models.Payments;
import com.insurance.HealthInsurance.rowmappers.ClaimsMapper;
import com.insurance.HealthInsurance.rowmappers.DiseseDetailsRowMapper;
import com.insurance.HealthInsurance.rowmappers.InsurancePackageCoveredDiseaseRowMapper;
import com.insurance.HealthInsurance.rowmappers.InsurancePackageRowMapper;
import com.insurance.HealthInsurance.rowmappers.ClaimBillsRowMappers;
import com.insurance.HealthInsurance.rowmappers.ClaimsRowMapper;
import com.insurance.HealthInsurance.rowmappers.ClaimsssMapper;
import com.insurance.HealthInsurance.rowmappers.PaymentMapper;

@Component
public class InsuranceClaimRepo implements InsuranceClaim {

	private static final String GET_INSURANCE_PACKAGES = "SELECT * FROM InsurancePackages";
	private static final String GET_COVERED_DISEASES_BY_PACKAGE_ID = "SELECT * FROM InsurancePackageCoveredDiseases WHERE insp_id = ?";
	private static final String GET_DISEASE_DETAILS_BY_DISEASE_ID = "select * from DiseaseDetails where disc_id=?";
	private static final String GET_FILTERED_PACKAGES = "select * FROM InsurancePackages where insp_status=? and ? BETWEEN insp_agelimit_start AND insp_agelimit_end;";
	private static final String GET_PACKAGES_BY_STATUS = "select * FROM InsurancePackages where insp_status=?";
	private static final String GET_FILTERED_PACKAGES_BY_AGE = "select * FROM InsurancePackages where ? BETWEEN insp_agelimit_start AND insp_agelimit_end;";


	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void addClaim(Claim claim) {

		String query = "insert into Claims(patient_id,patient_name, date_of_birth, gender, contact_number, address, joined_date, disease, diagnosis, treatment, room_charges, medicine_bill, document_path) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] values = { claim.getPatientId(), claim.getPatientName(), claim.getDateOfBirth(), claim.getGender(),
				claim.getContactNumber(), claim.getAddress(), claim.getJoinedDate(), claim.getDisease(),
				claim.getDiagnosis(), claim.getTreatment(), claim.getRoomCharges(), claim.getMedicineBill(),
				claim.getDocumentPath() };

		jdbcTemplate.update(query, values);
	}

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

	/// Email sending for login
	public int sendmail(String to_mail) {
		String to = to_mail;
		String subject = "Password Reset";

		int OTP = generateOTP();
		String body = "The OTP for the Password Reset: " + OTP;
		sendEmail(to, subject, body);

		return OTP;
	}

	private static void sendEmail(String to, String subject, String body) {
		String host = "smtp.gmail.com";
		int port = 587;
		String username = "avengersbtrs@gmail.com";
		String password = "urpr twig ffeb uqlx";

		// Set properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		// Create session
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create message
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	private static int generateOTP() {
		Random random = new Random();
		int randomNumber = 100000 + random.nextInt(900000);

		return randomNumber;
	}

	@Override
	public int resetpwd(String email, String pwd) {
		return jdbcTemplate.update("update checkdetails set password='" + pwd + "' where username='" + email + "'");
	}

	@Override
	public int checkCredentials(LoginClass lc) {

		String sql = "SELECT COUNT(*) FROM checkdetails WHERE username = '" + lc.getUser_name() + "' and password='"
				+ lc.getPassword() + "'";
		System.out.println(sql);
		// Execute the SQL query and return the count
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	///////////////////////////
	// ListClaims
	private String SQL_GET_CLAIMS = "select * from  Claims";
	private String SQL_GET_FILTERED_CLAIMS = "select * from  Claims where clam_status=?";
	private String SQL_GET_CLAIM_BY_ID = "select * from  Claims where clam_id=?";

	@Override
	public ArrayList<Claims> getAllClaims() {

		return (ArrayList<Claims>) jdbcTemplate.query(SQL_GET_CLAIMS, new ClaimsMapper());
	}

	@Override
	public ArrayList<Claims> getFilteredClaims(String status) {
		// TODO Auto-generated method stub
		return (ArrayList<Claims>) jdbcTemplate.query(SQL_GET_FILTERED_CLAIMS, new Object[] { status },
				new ClaimsMapper());
	}

	@Override
	public Claims getClaimById(int clamId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(SQL_GET_CLAIM_BY_ID, new Object[] { clamId }, new ClaimsMapper());
	}
	
	
	
	//DashBoard
	private static final String SELECT_ALL_CLAIM_BILLS = "SELECT * FROM claim_s where clam_status='APPR' or clam_status='UPRO' ";
	private static final String SELECT_FULL_CLAIM_BILLS = "SELECT * FROM claim_s WHERE clam_status = 'APPR'";
	private static final String SELECT_FULL_CLAIMED_AMOUNT = "SELECT * FROM claim_bills WHERE clbl_status = 'FULL'";
	private static final String SELECT_TOTAL_AMOUNT = "SELECT * FROM claim_bills WHERE clbl_status = 'FULL' or clbl_status='PART' ";
	private static final String SELECT_ALL_REJECTED = "SELECT * FROM claim_bills where clbl_status='RJCT' or clbl_status='PART'";
	
	
	
	@Override
	public List<Claims> getAllApplicants() {
		return jdbcTemplate.query(SELECT_ALL_CLAIM_BILLS, new ClaimsRowMapper());

	}

	@Override
	public List<Claims> getAllClaimss() {
		return jdbcTemplate.query(SELECT_FULL_CLAIM_BILLS, new ClaimsRowMapper());
	}

	

	

	@Override
	public List<ClaimBills> getRejectedLoans() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SELECT_ALL_REJECTED, new ClaimBillsRowMappers());

	}

	

	@Override
	public List<ClaimBills> getClaimedAmount() {

		return jdbcTemplate.query(SELECT_FULL_CLAIMED_AMOUNT, new ClaimBillsRowMappers());
	}

	@Override
	public List<ClaimBills> getTotalAmount() {

		return jdbcTemplate.query(SELECT_TOTAL_AMOUNT, new ClaimBillsRowMappers());
	}
	/////////
	//payments
	String Get_Payment = "select * from Payments";
	String Get_PaymentById ="select * from Payments where paymentid=?";

	@Override
    public List<Payments> getPayments() {
        return jdbcTemplate.query(Get_Payment, new PaymentMapper());
    }

	@Override
    public Payments getPaymentById(String paymentId) {
        return jdbcTemplate.queryForObject(Get_PaymentById, new Object[] { paymentId }, new PaymentMapper());
    }

}
