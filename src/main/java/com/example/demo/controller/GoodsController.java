package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Goodsdao;
import com.example.demo.vo.GoodsVo;
import com.google.gson.Gson;


@RestController
public class GoodsController {
	
	@Autowired
	private Goodsdao dao;

	public void setGoodsdao(Goodsdao goodsdao) {
		this.dao = goodsdao;
	}
	@RequestMapping(value = "/listGoods" , produces ="application/json;charset=UTF-8")
	public String listGoods() {
		String str ="";
		List<GoodsVo> list = dao.listGoods();
		Gson gson = new Gson();
		str = gson.toJson(list);
		System.out.println("컨트롤러 동작");
		return str;
	}
	
}
