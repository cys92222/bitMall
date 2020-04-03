package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.Goodsdao;
import com.example.demo.vo.GoodsVo;
import com.google.gson.Gson;


@RestController
public class GoodsController {
	
	@Autowired
	private Goodsdao dao;


	public void setDao(Goodsdao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listGoods.do")
	public ModelAndView listAll(String keyword, String searchcolumn){
		ModelAndView mav = new ModelAndView();
		if(keyword == null) {				
			keyword = "";
		}
		if(searchcolumn == null) { 			
			searchcolumn ="";
		}
		HashMap map = new HashMap();	
		map.put("searchcolumn",searchcolumn);
		map.put("keyword", keyword);
		List<GoodsVo> listAll = dao.listAll(map);
		System.out.println(listAll);
		mav.addObject("listAll",listAll);
		mav.setViewName("listGoods");
		return mav;
	}
	
	// 상품등록
	@RequestMapping(value = "/insertGoods")
	public String insertGoods(GoodsVo g) {
		String str = "ok";
		dao.insertGoods(g);
		return str;
	}
	
	//상세보기 
	@RequestMapping(value = "/getGoods", produces = "application/json;charset=UTF-8")
	public String getGoods(int no) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.detailGoods(no));
		return str;
	}
	
	//상품삭제
	@RequestMapping(value = "/deleteGoods", produces = "application/json;charset=UTF-8")
	public String deleteGoods(GoodsVo g) {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.deleteGoods(g));
		return str;
	}
	
	//상품수정
		@RequestMapping(value = "/updateGoods", produces = "application/json;charset=UTF-8")
		public String updateEmp(GoodsVo g) {
			String str = "";
			Gson gson = new Gson();
			str = gson.toJson(dao.updateGoods(g));
			return str;
		}
	
}
