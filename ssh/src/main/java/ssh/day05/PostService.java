package ssh.day05;

import java.util.List;

public interface PostService {
	List<Post> list();

	void addComment(Integer id, String string, String comment);
}
