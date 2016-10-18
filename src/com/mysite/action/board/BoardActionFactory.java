package com.mysite.action.board;

import com.mysite.action.main.MainAction;
import com.mysite.action.user.JoinAction;
import com.mysite.action.user.JoinFormAction;
import com.mysite.action.user.JoinSuccessAction;
import com.mysite.action.user.LoginAction;
import com.mysite.action.user.LoginFormAction;
import com.mysite.action.user.LoginOutAction;
import com.mysite.action.user.ModifyAction;
import com.mysite.action.user.ModifyFormAction;
import com.mysite.web.Action;
import com.mysite.web.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		Action action = null;
		if ("".equals(actionName)) {
		
		} else if ("".equals(actionName)) {
			
		}
		return action;
	}

}
