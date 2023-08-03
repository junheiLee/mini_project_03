package com.team08.service;

import java.util.ArrayList;

import com.team08.dao.ProductDAO;
import com.team08.dto.ProductVO;

public class ItemService {

	private static ItemService instance = new ItemService();
	private ProductDAO dao;
	
	private ItemService() {
		this.dao = ProductDAO.getInstance();
	}
	
	public static ItemService getInstance() {
		return instance;
	}
	
	/**
	 * 상품 번호에 해당하는 ProductVO 가져오는 메서드
	 * 
	 * @param pseq 상품 번호
	 * @return ProductVO
	 */
	public ProductVO getProduct(String pseq) {
		return dao.getProduct(pseq);
	}

	/**
	 * 상품 목룍에 해당하는 상품 목록 가져오는 메서드	
	 * 
	 * @param kind 상품 종료
	 * @return ArrayList<ProductVO>
	 */
	public ArrayList<ProductVO> listKindProduct(String kind) {
		return dao.listKindProduct(kind);
	}
}
