package ssh.day04;

import java.util.List;

public interface ProductDao {
	
	void add(Product p);
	
	List<Product> findAll();

	Product findById(Integer id);

	void delete(Product p);
	
}
