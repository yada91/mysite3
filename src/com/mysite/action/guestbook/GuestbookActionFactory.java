package com.mysite.action.guestbook;

import com.mysite.web.Action;
import com.mysite.web.ActionFactory;

public class GuestbookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if ("add".equals(actionName)) {
			action = new AddAction();
		} else if ("deleteform".equals(actionName)) {
			action = new DeleteformAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if ("ajax".equals(actionName)) {
			action = new AjaxAction();
		} else if ("ajax-list".equals(actionName)) {
			action = new AjaxListAction();
		} else if ("ajax-add".equals(actionName)) {
			action = new AjaxAddAction();
		}  else if ("ajax-delete".equals(actionName)) {
			action = new AjaxDeleteAction();
		}else {
			action = new ListAction();
		}
		return action;
	}

}
