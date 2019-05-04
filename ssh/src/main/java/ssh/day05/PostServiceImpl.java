package ssh.day05;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {

	@Resource
	private PostDao postDao;
	
	@Resource 
	private CommentDao commentDao;
	
	public List<Post> list() {
		return postDao.findAll();
	}
	
	public void addComment(
		Integer postId, String name, String content){
		
		if(content==null || content.trim().isEmpty()){
			throw new RuntimeException("回复不能空");
		}
		Comment comment = new Comment(
				null, postId, name, content, new Date());
		commentDao.save(comment);
	}
}






