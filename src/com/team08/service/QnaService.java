package com.team08.service;

import java.util.ArrayList;

import com.team08.dao.QnaDAO;
import com.team08.dto.QnaVO;

public class QnaService {

	private static QnaService instance = new QnaService();
	private QnaDAO dao;
	
	private QnaService() {
		this.dao = QnaDAO.getInstance();
	}
	
	public static QnaService getInstance() {
		return instance;
	}
	
	public void insertQna(QnaVO qnaVO, String sessionId) {
		dao.insertqna(qnaVO, sessionId);
	}
	
	public ArrayList<QnaVO> listQna(String sessionId) {
		return dao.listQna(sessionId);
	}
	
	public QnaVO getQna(int qseq) {
		return dao.getQna(qseq);
	}

}
