package jaehyun.action;

import jaehyun.web.main.WebUtil;
import jaehyun.web.web.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		WebUtil.forwarding( request,response,"/views/main/index.jsp");

	}

}
