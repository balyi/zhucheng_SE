package ssh.day04;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("productService")
@Transactional
public class ProductServiceImpl 
	implements ProductService{

	@Resource
	private ProductDao productDao; 
	
	public List<Product> list() {
		return productDao.findAll();
	}
	
	public void save(Product product) {
		if(product.getName()==null ||
				product.getName().trim().isEmpty()){
			throw new NameEmptyException("名称不能空");
		}
		if(product.getPrice()==null){
			throw new PriceEmptyException("价格不能空");
		}
		product.setCreateDate(new Date()); 
		product.setId(null); 
		productDao.add(product); 
	}
	
	public void delete(Integer id) {
		if(id==null){
			throw new RuntimeException("ID不能空");
		}
		Product p = productDao.findById(id);
		if(p==null){
			throw new RuntimeException("ID错误");
		}
		productDao.delete(p);
	}
}













