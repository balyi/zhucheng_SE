package ssh.test;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssh.day05.Post;
import ssh.day05.PostDao;

public class PostDaoTest {
	ClassPathXmlApplicationContext ctx;
	PostDao dao;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext(
				"spring-orm.xml"); 
		dao=ctx.getBean(
				"postDao", PostDao.class);
	}
	@After
	public void destory(){
		ctx.close();
	}
	
	@Test
	public void testFindAll(){
		List<Post> list=dao.findAll();
		for (Post post : list) {
			System.out.println(post);
		}
	}
}








