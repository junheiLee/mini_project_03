package com.team08.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team08.service.AdminService;
import com.team08.util.AdminCode;


@WebServlet("/admin/account/*")
public class AdminAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static AdminService service = AdminService.getInstance();
	private String url = "";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = request.getPathInfo();
		System.out.println("path= " + path);
		if(path.equals("/loginForm")) {
			loginForm();
		} else if(path.equals("/login")) {
			login(request);
		} else if(path.equals("/logout")) {
			logout(request);
		} else {
			
		}	
		System.out.println("url="+ url);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void loginForm() {
		this.url="/admin/main.jsp";
	}
	
	private void login(HttpServletRequest request) {
		this.url="/admin/account/loginForm";
		String msg = "";
		String adminId = request.getParameter("workerId").trim();
		String adminPwd = request.getParameter("workerPwd").trim();
		
		int code = service.getAdminCode(adminId, adminPwd);
		if(code == AdminCode.WORKER) {
			HttpSession session = request.getSession();
			session.setAttribute("workerId", adminId);
			url = "admin/items/list";
		} else if (code == AdminCode.INCORRECT_PWD) {
			msg = "비밀 번호를 확인하세요.";
		} else if (code == AdminCode.NOT_WORKER) {
			msg = "아이디를 확인하세요";
		}
		request.setAttribute("message", msg);
	}
	
	private void logout(HttpServletRequest request) {
		url = "/admin/account/loginForm";
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
			request.setAttribute("message", "");
		}
	}
}
