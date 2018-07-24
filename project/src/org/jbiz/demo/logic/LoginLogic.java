package org.jbiz.demo.logic;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.jbiz.demo.db.bean.UserEntity;
import org.jbiz.demo.db.dao.UserDao;
import org.jbiz.demo.logic.param.LoginLogicParam;

import fw.jbiz.ext.json.ZSimpleJsonObject;
import fw.jbiz.logic.ZLogicParam;

public class LoginLogic extends BaseZLogic {

	@Override
	protected boolean execute(ZLogicParam logicParam, ZSimpleJsonObject res, EntityManager em) throws Exception {
		
		LoginLogicParam myParam = (LoginLogicParam)logicParam;
		
		String account = myParam.getAccount();
		String password = myParam.getPassword();
		
		// find db
		UserEntity user = new UserDao(em).findByAccount(account);
		
		if (user == null) {
			res.add("status", -11)
			.add("msg", "用户不存在");
			
			return false;
		}
		
		if (!password.equals(user.getPassword())) {

			res.add("status", -12)
			.add("msg", "密码错误");
			
			return false;
			
		}
		
		
		
		res.add("status", 1)
			.add("msg", "ok")
			.add("userId", user.getUserId())
			.add("apiKey", user.getApiKey())
			.add("nickName", user.getNickName());

		return true;
	}

	@Override
	protected boolean validate(ZLogicParam logicParam, ZSimpleJsonObject res, EntityManager em) throws Exception {

		LoginLogicParam myParam = (LoginLogicParam)logicParam;
		
		String account = myParam.getAccount();
		String password = myParam.getPassword();
		
		if (StringUtils.isEmpty(account)
				|| StringUtils.isEmpty(password)) {
			
			res.add("status", -3)
				.add("msg", "参数错误");
			
			return false;
		}
		
		
		return true;
	}

	
   /*
    * 身份认证
    */
	@Override
   protected boolean auth(ZLogicParam logicParam, ZSimpleJsonObject res, EntityManager em){
		return true;
	}

}
