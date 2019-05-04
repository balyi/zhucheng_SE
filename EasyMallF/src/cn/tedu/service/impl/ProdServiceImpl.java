package cn.tedu.service.impl;

import java.util.List;

import cn.tedu.dao.ProdDao;
import cn.tedu.entity.Product;
import cn.tedu.factory.BasicFactory;
import cn.tedu.service.ProdService;
//Ctrl+1->Enter(�Զ�������δʵ�ֵĿշ���)
public class ProdServiceImpl implements ProdService {
	//����dao����
	private ProdDao prodDao = BasicFactory.getFactory().
				getInstance(ProdDao.class);
	public List<Product> findAll() {
		return prodDao.findAll();
	}
	public boolean changePnum(String id, int pnum) {
		//Ctrl+D:ɾ��������ڵ��С�
		//����dao��ķ���������Ӱ�������
		int row = prodDao.changePnum(id,pnum);
		//����row�����޸ĳɹ�����ʧ��
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
