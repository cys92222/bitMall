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
	
	public int insertGoods(GoodsVo g) {
		return GoodsManager.insertGoods(g);
	}
	
	public int updateGoods(GoodsVo g) {
		return GoodsManager.updateGoods(g);
	}
	
	public int deleteGoods(GoodsVo g) {
		return GoodsManager.deleteGoods(g);
	}
	
	public GoodsVo detailGoods(int no) {
		return GoodsManager.detailGoods(no);
	}
	
}
