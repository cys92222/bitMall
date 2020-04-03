package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.GoodsVo;


public class GoodsManager {
	
	public static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public static List<GoodsVo> listAll(){
		SqlSession session = factory.openSession();
		List<GoodsVo> list = session.selectList("goods.listAll");
		session.close();
		System.out.println("매니저동작");
		return list;
	} 
	
	public static int insertGoods(GoodsVo g) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("goods.insert", g);
		session.commit();
		session.close();
		return re;
	}
	
	public static int deleteGoods(GoodsVo g) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.insert("goods.delete", g);
		session.commit();
		session.close();
		return re;
	}
	
	public static int updateGoods(GoodsVo g) {
		int re = -1;
		SqlSession session = factory.openSession();
		re = session.update("goods.update", g);
		session.commit();
		session.close();
		return re;
	}
	
	public static GoodsVo detailGoods(int no) {
		SqlSession session = factory.openSession();
		GoodsVo g = session.selectOne("goods.detail", no);
		session.close();
		System.out.println("매니저동작");
		return g;
	}

	
	
	
}
