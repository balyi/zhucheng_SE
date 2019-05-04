package cn.tedu.service.impl;

import java.util.List;

import cn.tedu.dao.ProdDao;
import cn.tedu.entity.Product;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.ProdService;
//Ctrl+1->Enter(自动生成了未实现的空方法)
public class ProdServiceImpl implements ProdService {
	//创建dao对象
	private ProdDao prodDao = BasicFactory.getFactory().
				getInstance(ProdDao.class);
	public List<Product> findAll() {
		return prodDao.findAll();
	}
	public boolean changePnum(String id, int pnum) {
		//Ctrl+D:删除光标所在的行。
		//调用dao层的方法，返回影响的行数
		int row = prodDao.changePnum(id,pnum);
		//根据row返回修改成功还是失败
		return row==1;
	}
	public boolean deleteProdById(String id) {
		int row = prodDao.deleteProdById(id);
		return row==1;
	}
	public List<Product> findAllByKey(String name, String cate, Double min,
			Double max) {
		return prodDao.findAllByKey(name,cate,min,max);
	}
	public Product findProdById(String id) {
		return prodDao.findProdById(id);
	}
	
}
