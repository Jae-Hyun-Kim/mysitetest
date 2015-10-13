package jaehyun.action;

import jaehyun.web.web.Action;
import jaehyun.web.web.ActionFactory;

public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = new IndexAction();
		return action;
	}

}
