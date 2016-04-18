package bg.softuni.socialnetwork.services;

import java.util.List;

import bg.softuni.socialnetwork.entity.Comment;

public interface CommentService {
	List<Comment> getAllCommentsForPost(Long postId);
	List<Comment> getAllComments();
	Comment getComemntById(Long id);
	boolean addComment(Comment comment);
	
}
