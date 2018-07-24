package org.jbiz.demo.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.jbiz.demo.db.bean.UserEntity;
import org.jbiz.demo.db.dao.UserDao;
import org.jbiz.demo.logic.param.GetUsersLogicParam;

import fw.jbiz.ext.json.ZSimpleJsonObject;
import fw.jbiz.logic.ZLogicParam;

public class GetUsersLogic extends BaseZLogic {

	@Override
	protected boolean execute(ZLogicParam logicParam, ZSimpleJsonObject res, EntityManager em) throws Exception {
		
		GetUsersLogicParam myParam = (GetUsersLogicParam)logicParam;
		
		
		// find db
		List<UserEntity> list = new UserDao(em).findUserList();
		
		List<Map<String, String>> retList = new ArrayList<Map<String, String>>();
		if (list == null || list.isEmpty()) {

			res.add("status", 1)
				.add("msg", "ok")
				.add("results", retList);
			
			return true;
		}
		
		for(UserEntity user: list) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("account", user.getAccount());
			map.put("userId", user.getUserId());
			map.put("nickName", user.getNickName());
			
			retList.add(map);
		}
		

		res.add("status", 1)
			.add("msg", "ok")
			.add("count", retList.size())
			.add("results", retList);
		
		return true;
		
	}

	@Override
	protected boolean validate(ZLogicParam logicParam, ZSimpleJsonObject res, EntityManager em) throws Exception {
		
		return true;
	}


}
