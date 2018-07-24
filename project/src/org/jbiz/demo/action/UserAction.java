package org.jbiz.demo.action;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;
import org.jbiz.demo.logic.GetUsersLogic;
import org.jbiz.demo.logic.LoginLogic;
import org.jbiz.demo.logic.param.GetUsersLogicParam;
import org.jbiz.demo.logic.param.LoginLogicParam;


@Produces("application/json;charset=UTF-8")
@Path("user")
public class UserAction extends BaseZAction {

	static Logger logger = Logger.getLogger(UserAction.class);

	@POST
	@Path("getUsers.do")
	public String login(
			@FormParam("userId") String userId,
			@FormParam("apiKey") String apiKey,
			@Context HttpServletRequest request) {
		
		GetUsersLogicParam logicParam = new GetUsersLogicParam(userId, apiKey, request);
		
		
		return new GetUsersLogic().process(logicParam);
	}
}
