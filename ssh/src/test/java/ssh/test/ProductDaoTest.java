package ssh.test;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssh.day04.Product;
import ssh.day04.ProductDao;

public class ProductDaoTest {
	ClassPathXmlApplicationContext ctx;
	ProductDao dao;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext(
				"spring-orm.xml"); 
		dao=ctx.getBean(
				"productDao", ProductDao.class);
	}
	@After
	public void destory(){
		ctx.close();
	}
	
	@Test
	public void testAddProduct(){
		Product p=new Product(null, 
				"鼠标", 12.0, new Date());
		dao.add(p); 
	}
	
	@Test
	public void testFindAll(){
		List<Product> list=dao.findAll();
		for (Product product : list) {
			System.out.println(product); 
		}
	}
}








