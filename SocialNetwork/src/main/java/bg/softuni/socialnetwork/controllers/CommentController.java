package bg.softuni.socialnetwork.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import bg.softuni.socialnetwork.entity.Comment;
import bg.softuni.socialnetwork.entity.UserProfile;
import bg.softuni.socialnetwork.services.CommentService;
import bg.softuni.socialnetwork.services.PostService;
import bg.softuni.socialnetwork.services.UserService;
import bg.softuni.socialnetwork.utils.UserUtils;
@Controller
public class CommentController {
	
	@Autowired
	private CommentService comentService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/profile/{userId}/posts/{postId}", method = RequestMethod.POST)
	public String addComment(Model model,@PathVariable String userId, @PathVariable String postId,@ModelAttribute(value = "comment") Comment comment) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String user =UserUtils.getUser().getUsername();
		UserProfile currentUser = userService.getUsers(user).get(0);
	 	long count = comentService.getAllComments().size();
	 	Long id = Long.parseLong(postId);
		Comment newComment = new Comment();
		
		newComment.setId(count+1);
		newComment.setCreatedOn(new Date());
		newComment.setPostId(id);
		newComment.setAuthorName(currentUser.getUsername());
		newComment.setAuthorId(currentUser.getId());
		newComment.setContent(comment.getContent());
		
		comentService.addComment(newComment);
		return "redirect:/profile/"+userId;

	}
	@RequestMapping(value = "/profile/{userId}/posts/{postId}", method = RequestMethod.GET)
	public String getComments (Model model,@PathVariable String postId){
		Long id = Long.parseLong(postId);
		String username = UserUtils.getUser().getUsername();
		UserProfile currentUser = userService.getUsers(username).get(0);
		List<Comment> comments = comentService.getAllCommentsForPost(id);
		model.addAttribute("comments",comments);
		model.addAttribute("postId",postId);
		model.addAttribute("username", currentUser.getUsername());
		model.addAttribute("authorId", currentUser.getId());
		model.addAttribute("createdOn", new Date());
		return "comments";
		
		
		
	}
}
