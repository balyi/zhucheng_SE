package ssh.day05;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("postDao")
@Transactional
public class PostDaoImpl implements PostDao {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public List<Post> findAll() {
		String hql="from Post";
		return (List<Post>)hibernateTemplate.find(hql);
	}
}







