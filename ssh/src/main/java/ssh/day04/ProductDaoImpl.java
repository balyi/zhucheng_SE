package ssh.day04;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void add(Product p) {
		hibernateTemplate.save(p);
	}
	
	public List<Product> findAll() {
		//sql: select * from t_product
		//hql: from Product
		String hql = "from Product";
		List<Product> list= (List<Product>)
				hibernateTemplate.find(hql);
		return list;
	}
	
	
	public void delete(Product p) {
		hibernateTemplate.delete(p); 
	}
	
	public Product findById(Integer id) {
		return hibernateTemplate.get(Product.class, id); 
	}
}









