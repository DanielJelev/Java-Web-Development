package bg.softuni.socialnetwork.dao;

import java.util.List;

import bg.softuni.socialnetwork.entity.Post;

public interface PostDao {

	List<Post> getAllPost();
	
	List<Post> getAllPostForUser(Long userId);
	
	boolean addPost(Post post);
	
	Post getPostById(Long id);
	
	boolean deletePost(Post post);
}
