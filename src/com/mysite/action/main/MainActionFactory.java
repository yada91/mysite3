package com.mysite.action.main;

import com.mysites3.web.Action;
import com.mysites3.web.ActionFactory;

public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {

		return new MainAction();
	}

}
