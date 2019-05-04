package edu.taihu.logistics.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.taihu.logistics.pojo.Product;

public interface ProductMapper {
	public List<Product> findAll(String userId);

	void addProduct(Product product);

	public void delete(String[] ids);

	public List<Product> findProductById(String[] productIds);

	public void changeState(@Param("ids")String[] productIds, @Param("productState")Integer i);

	public List<Product> findAllProducts();

}
