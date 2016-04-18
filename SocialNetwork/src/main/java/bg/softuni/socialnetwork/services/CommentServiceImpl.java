package bg.softuni.socialnetwork.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.softuni.socialnetwork.dao.CommentDao;

import bg.softuni.socialnetwork.entity.Comment;


@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao commentDao;

	@Override
	public List<Comment> getAllCommentsForPost(Long postId) {
		return commentDao.getAllCommentsForPost(postId);
	}

	@Override
	public List<Comment> getAllComments() {
		return commentDao.getAllComments();
	}

	@Override
	public Comment getComemntById(Long id) {
		return commentDao.getComemntById(id);
	}

	@Override
	public boolean addComment(Comment comment) {
		commentDao.addComment(comment);
		return true;
	}

}
