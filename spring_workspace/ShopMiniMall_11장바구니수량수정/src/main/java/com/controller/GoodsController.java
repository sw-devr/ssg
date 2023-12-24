package com.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	GoodsService gService;

	@GetMapping("/goodsRetrieve")
	@ModelAttribute("goodsRetrieve")
	public GoodsDTO goodsRetrieve(@RequestParam String gCode, Model m) {
		GoodsDTO dto = gService.goodsRetrieve(gCode);
		// model 1. Model m 파라미터로 받는 방법
		// model 2. ModelAttribute로 View 설정 후, 반환을 GoodsDTO로 하는 방법
		return dto;
	}

	// Cart 저장
	@GetMapping("/CartAddServlet")
	public String cartAdd(CartDTO cDTO, HttpSession session) {
		// 세션에 저장된 userid 포함 장바구니 값 전달
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		cDTO.setUserid(mDTO.getUserid());
		int n = gService.cartAdd(cDTO);

		return "goods/cartAddSuccess";
	}

	// Cart 목록
	@GetMapping("/CartListServlet")
	public ModelAndView cartList(HttpSession session) {
		MemberDTO mDTO = (MemberDTO) session.getAttribute("login");
		String userid = mDTO.getUserid();
		
		List<CartDTO> list = gService.cartList(userid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cartList",list);
		mav.setViewName("cartList");
		
		return mav;
	}


	// Cart 수정
	@GetMapping("/CartUpdateServlet")
	@ResponseBody
	public void CartUpdate(@RequestParam HashMap<String, Integer> map) {
		int num = gService.cartUpdate(map);
		return ;
	}
	
}
