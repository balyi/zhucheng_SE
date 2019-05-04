package ssh.day05;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ssh.day02.JsonResult;

@Controller
@Scope("prototype")
public class PostAction extends JsonAction {
	
	@Resource
	private PostService postService;
	
	public String list(){
		List<Post> list = postService.list();
		jsonResult=new JsonResult(list);
		return JSON;
	}
	
	private Integer id;
	private String comment;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String replay(){
		 
		postService.addComment(id, "刘苍松", comment);
		jsonResult = new JsonResult("成功了!");
		return JSON;
	 
	}
}















