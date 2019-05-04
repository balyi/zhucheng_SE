package ssh.day05;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("commentDao")
@Transactional
public class CommentDaoImpl implements CommentDao{
	
	@Resource
	private HibernateTemplate hibernateTemplate; 
	
	public void save(Comment comment) {
		hibernateTemplate.save(comment);
	}
}





