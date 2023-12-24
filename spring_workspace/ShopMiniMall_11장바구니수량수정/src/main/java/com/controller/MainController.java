package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.GoodsDTO;
import com.service.GoodsService;

@Controller
public class MainController {
	
	@Autowired
	GoodsService gService;
	
	@GetMapping("/main")
	public String main(@RequestParam(required = false, defaultValue="top") String gCategory
						,Model m){
		//RequestParam 없으면 400에러 발생
		//RequestParam(required=true)가 기본값이므로 false를 주거나 초기값주거나 하면 됨
		
		//Goods 테이블 데이터 카테고리별로 검색
		List<GoodsDTO> list = gService.goodsList(gCategory);
		m.addAttribute("goodsList",list); //기본값 requestScope -> main.jsp와 goodslist.jsp 둘 다 이용가능
		
		return "main"; //WEB-INF/views/main.jsp
	}
}
