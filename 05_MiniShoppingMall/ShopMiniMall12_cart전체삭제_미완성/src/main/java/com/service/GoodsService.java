package com.service;

import java.util.HashMap;
import java.util.List;

import com.dto.CartDTO;
import com.dto.GoodsDTO;

public interface GoodsService {
	public List<GoodsDTO> goodsList(String gCategory);
	public GoodsDTO goodsRetrieve(String gCode) ;
	//cart 저장
	public int cartAdd(CartDTO dto);
	// Cart 목록
	public List<CartDTO> cartList(String userid);
	
	public int cartUpdate(HashMap<String, Integer> map);
}
