package com.mysite.action.user;

import com.mysite.action.main.MainAction;
import com.mysites3.web.Action;
import com.mysites3.web.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if ("joinform".equals(actionName)) {
			action = new JoinFormAction();
		} else if ("join".equals(actionName)) {
			action = new JoinAction();
		} else if ("joinsuccess".equals(actionName)) {
			action = new JoinSuccessAction();
		} else if ("loginform".equals(actionName)) {
			action = new LoginFormAction();
		} else if ("login".equals(actionName)) {
			action = new LoginAction();
		} else if ("logout".equals(actionName)) {
			action = new LoginOutAction();
		} else if ("modifyform".equals(actionName)) {
			action = new ModifyFormAction();
		} else if ("modify".equals(actionName)) {
			action = new ModifyAction();
		} else {
			action = new MainAction();
		}
		return action;
	}

}
