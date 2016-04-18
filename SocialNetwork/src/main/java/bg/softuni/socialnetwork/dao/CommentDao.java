package bg.softuni.socialnetwork.dao;

import java.util.List;

import bg.softuni.socialnetwork.entity.Comment;

public interface CommentDao {
	List<Comment> getAllCommentsForPost(Long postId);
	List<Comment> getAllComments();
	Comment getComemntById(Long id);
	boolean addComment(Comment comment);
	
}
