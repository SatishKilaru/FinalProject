package com.insurance.Hospital.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.Hospital.contractors.LoginImpDao;
import com.insurance.Hospital.models.LoginClass;

@Repository
public class LoginRepository {

	@Autowired
	LoginImpDao lid;

	public int checkCredentials(LoginClass lc) {
		return lid.checkCredentials(lc);
	}

	public int sendmail(String to_mail) {
		return lid.sendmail(to_mail);
	}

	public int resetpwd(String email, String pwd) {
		return lid.resetpwd(email, pwd);
	}

}
