package ssh.day04;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ProductAction implements SessionAware{
	
	private Map<String, Object> session;
	public void setSession(
			Map<String, Object> session) {
		this.session = session;
	}
	
	
	@Resource 
	private ProductService productService;
	
	private List<Product> products;
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public String list(){
		products = productService.list();
		return "success";
	}
	
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	private String nameMessage;
	private String priceMessage;
	private String message;
	public String getNameMessage() {
		return nameMessage;
	}
	public void setNameMessage(String nameMessage) {
		this.nameMessage = nameMessage;
	}
	public String getPriceMessage() {
		return priceMessage;
	}
	public void setPriceMessage(String priceMessage) {
		this.priceMessage = priceMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String save(){
		try{
			productService.save(product);
			return "success";
		}catch(NameEmptyException e){
			e.printStackTrace();
			nameMessage = e.getMessage();
			return "error";
		}catch(PriceEmptyException e){
			e.printStackTrace();
			priceMessage = e.getMessage();
			return "error";
		}catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			return "error";
		}
	}
	
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	//ProductAction
	public String delete(){
		try {
			productService.delete(id);
			session.put("message", "删除成功!");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			//将消息保存到session
			session.put("message", e.getMessage());
 			return "error";
		}
	}
}











