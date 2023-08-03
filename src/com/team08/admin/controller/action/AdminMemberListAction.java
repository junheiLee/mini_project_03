package com.team08.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team08.controller.action.Action;
import com.team08.dao.MemberDAO;
import com.team08.dto.MemberVO;

public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "admin/member/memberList.jsp";
		String key = "";
		if (request.getParameter("key") != null) {
			key = request.getParameter("key");
		}

		MemberDAO memberDAO = MemberDAO.getInstance();
		ArrayList<MemberVO> memberList = memberDAO.listMember(key);

		request.setAttribute("memberList", memberList);

		request.getRequestDispatcher(url).forward(request, response);
	}
}
