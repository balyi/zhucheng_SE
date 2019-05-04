package edu.taihu.logistics.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.taihu.logistics.mapper.ProductMapper;
import edu.taihu.logistics.pojo.Product;
import edu.taihu.logistics.pojo.UserInfo;
import edu.taihu.logistics.service.ProductService;
import edu.taihu.logistics.service.RedisService;
import edu.taihu.logistics.tool.Md5Utils;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private RedisService redisService;
	
	private final static String PRODUCT_KEY = "PRODUCT_ALL";
    private static final ObjectMapper MAPPER = new ObjectMapper();

	@Override
	public void addProduct(Product product) {
		String productId = UUID.randomUUID().toString();
		product.setProductId(productId);
		product.setProductState(0);
		Date date = new Date();
		product.setCreateTime(date);
		productMapper.addProduct(product);
	}

	@Override
	public List<Product> findAll(String userId) {
		/* try {
	            String data = this.redisService.get(PRODUCT_KEY);
	            if (StringUtils.isNoneEmpty(data)) {
	                // 将json转化为java对象
	            	System.out.println("************************");
	                return MAPPER.readValue(data,new TypeReference<List<Product>>(){});
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }*/
		 List<Product> products=productMapper.findAll(userId);
		 /*try {
	            // 保存数据到redis，类目变化不大，设置时间长些，一般10天。
	            this.redisService.set(PRODUCT_KEY, MAPPER.writeValueAsString(products), 60 * 60 * 24 * 10);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }*/
		return products;
	}

	@Override
	public void delete(String[] ids) {
		productMapper.delete(ids);
	}

	@Override
	public List<Product> findProductById(String[] productIds) {
		return productMapper.findProductById(productIds);
	}

	@Override
	public void changeState(String[] productIds, Integer i) {
		productMapper.changeState(productIds,i);
	}

	@Override
	public List<Product> findAll() {
		
		return productMapper.findAllProducts();
	}
	
}
