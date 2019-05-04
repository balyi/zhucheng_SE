package ssh.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ssh.day03.User;
import ssh.day04.Product;

public class HbmTestCase {
	SessionFactory factory;
	
	@Before
	public void init(){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory = cfg.buildSessionFactory();
	}
	
	@After
	public void destory(){
		factory.close();
	}
	
	@Test
	public void testSave(){
		User user=new User(
				1, "Tom", 10, 4.5, new Date());
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}
	
	@Test
	public void testGet(){
		Integer id=2;
		Session session = factory.openSession();
		User user=(User)session.get(User.class, id);
		System.out.println(user);
		session.close();
	}
	@Test
	public void testLoad(){
		Integer id=1;
		Session session = factory.openSession();
		User user=(User)session.load(User.class, id);
		System.out.println(user);
		session.close();
	}
	
	@Test
	public void testUpdate(){
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		User user = (User)session.get(User.class, 1);
		user.setName("Nemo");
		session.update(user);
		tx.commit();
		session.close();
	}
	
	@Test
	public void testDelete(){
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		User user = (User)session.get(User.class, 1);
		session.delete(user);
		tx.commit();
		session.close();
	}
	
	@Test 
	public void testAdd(){
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		User u1=new User(1, "Tom", 4, 4.5,new Date());
		User u2=new User(2, "Jerry", 6, 9.5,new Date());
		User u3=new User(3, "Andy", 8, 8.5,new Date());
		session.save(u1);
		session.save(u2);
		session.save(u3);
		tx.commit();
		session.close();
	}
	
	@Test
	public void testFindAll(){
		//sql: select * from t_user
		//hql: from User
		String hql="from User";
		Session session = factory.openSession();
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		for (User user : list) {
			System.out.println(user);
		}
		session.close();
	}
	
	@Test
	public void testFindAll2(){
		//sql: select t_id, t_name from t_user
		//hql: select new map(id as id, name as Name)
		//     from User
		Session session=factory.openSession();
		String hql = "select new map(id as id, "
				+ "name as Name) from User";
		Query query = session.createQuery(hql);
		List<Map<String, Object>> list=query.list();
		for (Map<String, Object> map : list) {
			System.out.println(map); 
		}
		session.close();
	}
	
	@Test
	public void testFindByParam(){
		//sql: select * from t_user 
		//     where t_salary < ?
		//hql: from User where salary<?
		String hql="from User where salary<?";
		Session session = factory.openSession();
		Query query = session.createQuery(hql);
		query.setDouble(0, 9);
		List<User> list=query.list();
		for (User user : list) {
			System.out.println(user); 
		}
		session.close();
	}
	
	@Test
	public void testFindNamedParam(){
		String hql="from User where salary<:salary";
		Session session=factory.openSession();
		Query query=session.createQuery(hql);
		//替换"名称"参数
		query.setDouble("salary", 9);
		List<User> list=query.list();
		for (User user : list) {
			System.out.println(user); 
		}
		session.close();
	}
	
	@Test
	public void testAutoUpdate(){
		//临时状态 user
		User user = new User(
				8, "Wang", 4, 4.5, new Date());
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		//user 是持久状态了 
		user.setSalary(100.0); 
		session.flush();
		tx.commit();
		session.close();
	}
	
	@Test
	public void testGetUser(){
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		User u =(User)session.get(User.class, 8);
		//u 是持久状态了
		u.setName("王"); 
		session.flush();
		tx.commit();
		session.close();
	}
	
	@Test
	public void testState(){
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		User user=(User)session.get(User.class, 8);
		session.clear();
		//session.evict(user);
		//对象user为游离状态
		user.setName("Mac"); 
		//将user对象从游离状态切换为持久状态
		session.update(user); 
		session.flush();
		tx.commit();
		session.close();
	}
	
	@Test
	public void testId(){
		User user = new User(
			null, "范传奇", 5, 200.0, new Date());
		Session session = factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		//hibernate 会自动返回 生成的ID
		System.out.println(user);
		tx.commit();
		session.close();
	}
	
	/**
	 * 自增类型ID
	 */
	@Test
	public void testAddProduct(){
		Product p = new Product(null, "汽车", 
				2300.0, new Date());
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(p);
		session.save(p);
		//Hibernate 或自动读取自增的ID
		System.out.println(p);
		tx.commit();
		session.close();
	}
}









































