package ssh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssh.day04.Product;
import ssh.day05.Comment;
import ssh.day05.Post;
import ssh.day05.User;

public class OrmTestCase {
	ClassPathXmlApplicationContext ctx;
	SessionFactory factory;
	@Before 
	public void init(){
		ctx = new ClassPathXmlApplicationContext(
				"spring-orm.xml");
		factory = ctx.getBean("sessionFactory",
				SessionFactory.class);
	}
	@After
	public void destory(){
		factory.close();
		ctx.close();
	}
	
	@Test
	public void testGetProduct(){
		Session session=factory.openSession();
		Product p = (Product)
				session.get(Product.class, 1);
		System.out.println(p); 
		session.close();
	}
	
	@Test
	public void testGetUser(){
		Session session=factory.openSession();
		User user = (User)session.get(User.class, 1);
		System.out.println(user); 
		session.close();
	}
	
	@Test
	public void testGetComment(){
		Session session=factory.openSession();
		Comment comment=(Comment)
			session.get(Comment.class, 1);
		System.out.println(comment);
		session.close();
	}
	
	@Test
	public void testGetPost(){
		Session session=factory.openSession();
		Post post=(Post)session.get(Post.class, 1);
		System.out.println(post); 
		session.close();
	}
	
	@Test
	public void testGetPost2(){
		Session session=factory.openSession();
		Post post=(Post)session.get(Post.class, 1);
		//post 的user属性是懒惰加载的, 如果不使用
		//user属性, 则不执行SQL读取user的数据
		System.out.println(post.getContent()); 
		//读取User的属性
		System.out.println(post.getUser());
		
		System.out.println(post.getComments());
		session.close();
	}
	@Test
	public void testGetPost3(){
		Session session=factory.openSession();
		Post post=(Post)session.get(Post.class, 1);
		//post 的user属性是懒惰加载的, 如果不使用
		//user属性, 则不执行SQL读取user的数据
		System.out.println(post.getContent()); 
		//读取User的属性
		System.out.println(post.getUser());
		session.close();
		System.out.println(post.getComments());
		
	}


}













