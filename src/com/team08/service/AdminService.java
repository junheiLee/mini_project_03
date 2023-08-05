package com.team08.service;

import com.team08.dao.WorkerDAO;

public class AdminService {

	private static AdminService instance = new AdminService();
	private WorkerDAO dao;
	
	private AdminService() {
		this.dao = WorkerDAO.getInstance();
	}
	
	public static AdminService getInstance() {
		return instance;
	}
	
	public int getAdminCode(String userId, String userPwd) {
		return dao.workerCheck(userId, userPwd);
	}
}
