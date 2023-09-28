package com.insurance.Hospital.contractors;

import com.insurance.Hospital.models.LoginClass;

public interface LoginImpDao {

	int checkCredentials(LoginClass lc);

	int resetpwd(String email, String pwd);

	int sendmail(String to_mail);
}
