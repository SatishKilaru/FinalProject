package com.insurance.Hospital.daos;

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

import com.insurance.Hospital.contractors.LoginImpDao;
import com.insurance.Hospital.models.LoginClass;
import com.insurance.Hospital.rowmappers.LoginClassMapper;

@Component
public class LoginDao implements LoginImpDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int checkCredentials(LoginClass lc) {

		String sql = "SELECT COUNT(*) FROM checktable WHERE username = '" + lc.getUser_name() + "' and password='"
				+ lc.getPassword() + "'";
		System.out.println(sql);
		// Execute the SQL query and return the count
		return jdbc.queryForObject(sql, Integer.class);
	}

	@Override
	public int resetpwd(String email, String pwd) {
		return jdbc.update("update checktable set password='" + pwd + "' where username='" + email + "'");
	}

	@Override
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

	public LoginClass getUserByUsername(String username) {
		String sql = "select * from checktable where username='" + username + "'";
		return jdbc.queryForObject(sql, new LoginClassMapper());
		
	}

}
