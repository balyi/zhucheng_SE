package ssh.day04;

import java.util.List;

public interface ProductService {
	
	List<Product> list();

	void save(Product product);

	void delete(Integer id);
	
}
