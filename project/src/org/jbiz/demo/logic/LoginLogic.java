package org.jbiz.demo.logic;

import javax.persistence.EntityManager;

import fw.jbiz.ext.json.ZSimpleJsonObject;
import fw.jbiz.logic.ZLogicParam;

public class LoginLogic extends BaseZLogic {

	@Override
	protected boolean execute(ZLogicParam logicParam, ZSimpleJsonObject res, EntityManager em) throws Exception {
		
		res.add("status", 1)
			.add("msg", "ok")
			.add("userId", "xxx")
			.add("apiKey", "yyy");

		return true;
	}

	@Override
	protected boolean validate(ZLogicParam logicParam, ZSimpleJsonObject res, EntityManager em) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
