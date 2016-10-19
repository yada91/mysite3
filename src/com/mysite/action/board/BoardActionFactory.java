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
		if ("writeform".equals(actionName)) {
			action = new WriteFormAction();
		} else if ("write".equals(actionName)) {
			action = new WriteAction();
		} else if ("view".equals(actionName)) {
			action = new ViewAction();
		} else if ("modifyform".equals(actionName)) {
			action = new BoardModifyFormAction();
		} else if ("modify".equals(actionName)) {
			action = new BoardModifyAction();
		} else if ("replyform".equals(actionName)) {
			action = new ReplyFormAction();
		} else if ("reply".equals(actionName)) {
			action = new ReplyAction();
		} else {
			action = new ListAction();
		}
		return action;
	}

}
