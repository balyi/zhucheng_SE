package edu.taihu.logistics.service;

import java.util.List;

import edu.taihu.logistics.pojo.Product;

public interface ProductService {
	public List<Product> findAll(String userId);

	void addProduct(Product product);

	public void delete(String[] ids);

	public List<Product> findProductById(String[] productIds);

	public void changeState(String[] productIds, Integer i);

	public List<Product> findAll();

}
