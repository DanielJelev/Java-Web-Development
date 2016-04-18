package bg.softuni.socialnetwork.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.softuni.socialnetwork.dao.PostDao;
import bg.softuni.socialnetwork.entity.Post;
@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostDao postDao;
	@Override
	public List<Post> getAllPostForUser(Long userId) {
		return postDao.getAllPostForUser(userId);
	}

	@Override
	public boolean addPost(Post post) {
		postDao.addPost(post);
		return true;
	}

	@Override
	public List<Post> getAllPost() {
		return postDao.getAllPost();
		
	}

	@Override
	public Post getPostById(Long id) {
		return postDao.getPostById(id);
		
	}

	@Override
	public boolean deletePost(Post post) {
		// TODO Auto-generated method stub
		return false;
	}



}
