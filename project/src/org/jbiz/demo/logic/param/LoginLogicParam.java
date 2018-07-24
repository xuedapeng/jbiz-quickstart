package org.jbiz.demo.logic.param;

import javax.servlet.http.HttpServletRequest;

import org.jbiz.demo.logic.BaseZLogicParam;

public class LoginLogicParam extends BaseZLogicParam {

	private String account;
	private String password;
	
	public LoginLogicParam(String _userId, String _apiKey, HttpServletRequest request) {
		super(_userId, _apiKey, request);
		// TODO Auto-generated constructor stub
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
