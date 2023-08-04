package com.team08.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team08.dto.MemberVO;
import com.team08.dto.QnaVO;
import com.team08.service.QnaService;


/**
 * Qna 관련 요청을 처리하는 서블릿
 * 
 * qna 작성 폼을 요청받으면 doGet 메서드를 통해 doHandle에서 요청 처리,
 * qna 상세 보기 요청을 받으면 doGet 메서드를 통해 doHandle에서 요청 처리,
 * qna 목록 보기 요청을 받으면 doGet 메서드를 통해 doHandle에서 요청 처리,
 * qna 작성 요청을 받으면 doPost 메서드를 실행하여 qna 저장을 진행한 후 qna list로 돌아간다.
 */
@WebServlet("/qnas/*")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final QnaService service = QnaService.getInstance();

	// write_form, view, list
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}
	
	// write
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getContextPath() + "/qnas/list";		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if(loginUser == null) {
			url = "/NonageServlet?command=login_form";
		} else {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setSubject(request.getParameter("subject"));
			qnaVO.setContent(request.getParameter("content"));
			
			service.insertQna(qnaVO, loginUser.getId());
		}
		response.sendRedirect(url);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String url = "";
		String path = request.getPathInfo();
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "/NonageServlet?command=login_form";
		} else {
			
			if(path.equals("/list")) {
				url = "/qna/qnaList.jsp";
				ArrayList<QnaVO> qnaList = service.listQna(loginUser.getId());
				request.setAttribute("qnaList", qnaList);
				
			}else if(path.equals("/view")) {
				url = "/qna/qnaView.jsp";
				int qseq = Integer.parseInt(request.getParameter("qseq"));
				QnaVO qnaVO = service.getQna(qseq);
				request.setAttribute("qnaVO", qnaVO);
				
			}else if(path.equals("/writeForm")) {
				url = "/qna/qnaWrite.jsp";
				
			}else {
				url = "/NonageServlet?command=login_form";
			}
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
