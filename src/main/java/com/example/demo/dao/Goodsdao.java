package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.GoodsManager;
import com.example.demo.vo.GoodsVo;

@Repository
public class Goodsdao {
		
	public List<GoodsVo> listGoods(){
		System.out.println("다오 동작");
		return GoodsManager.listAll();
	}
	
	
}
