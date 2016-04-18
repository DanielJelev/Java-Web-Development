package bg.softuni.socialnetwork.controllers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import bg.softuni.socialnetwork.entity.Post;
import bg.softuni.socialnetwork.entity.UserProfile;
import bg.softuni.socialnetwork.services.PostService;
import bg.softuni.socialnetwork.services.UserService;
import bg.softuni.socialnetwork.utils.UserUtils;


@Controller
public class PostController {
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/profile/{userId}", method = RequestMethod.POST)
	public ModelAndView addPost(Model model, @PathVariable String userId,@ModelAttribute(value = "post") Post post) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String user =UserUtils.getUser().getUsername();
		UserProfile currentUser = userService.getUsers(user).get(0);
		Long userIdPosts= Long.parseLong(userId);
	 	long count = postService.getAllPost().size();
		Post newPost = new Post();
		
		newPost.setId(count+1);
		newPost.setCreatedOn(new Date());
		newPost.setUserId(userIdPosts);
		newPost.setAuthorName(currentUser.getUsername());
		newPost.setAuthorId(currentUser.getId());
		newPost.setContent(post.getContent());
		
		postService.addPost(newPost);

		return new ModelAndView(new RedirectView(userId));
	}
	
	@RequestMapping(value = "/posts/{postId}/",method = RequestMethod.POST)
	public String deletePost(Model model, @PathVariable String postId ){
		Long id = Long.parseLong(postId);
		Post post = postService.getPostById(id);
		Long userId = post.getUserId();
		postService.deletePost(post);
		
		return "redirect:/profile/"+userId;
	}
	
	@RequestMapping(value = "/profile/{userId}/posts/",
			method = RequestMethod.GET)
	public String getPosts(Model model, @PathVariable String userId ){
		Long id = Long.parseLong(userId);
		List<Post> posts = postService.getAllPostForUser(id);

		model.addAttribute("posts",posts);
		
		return "posts";
	}
}
