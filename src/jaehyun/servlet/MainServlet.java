package jaehyun.servlet;

import jaehyun.action.MainActionFactory;
import jaehyun.web.web.Action;
import jaehyun.web.web.ActionFactory;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String actionName = request.getParameter("a"); // ?a= 
		
		ActionFactory af = new MainActionFactory();
		
		Action action = af.getAction(actionName);
		action.execute(request, response);
		
	}

}
