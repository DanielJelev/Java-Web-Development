package bg.softuni.socialnetwork.services;

import java.util.List;

import bg.softuni.socialnetwork.entity.Post;

public interface PostService {
	List<Post> getAllPostForUser(Long userId);
	List<Post> getAllPost();
	Post getPostById(Long id);
	boolean addPost(Post post);
	boolean deletePost(Post post);
	
}
