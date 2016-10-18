package com.mysite.action.main;

import com.mysite.web.Action;
import com.mysite.web.ActionFactory;

public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {

		return new MainAction();
	}

}
