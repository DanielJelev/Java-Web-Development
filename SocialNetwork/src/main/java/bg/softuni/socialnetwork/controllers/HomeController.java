package bg.softuni.socialnetwork.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.softuni.socialnetwork.constants.UrlConstants;
import bg.softuni.socialnetwork.entity.Post;
import bg.softuni.socialnetwork.entity.UserProfile;
import bg.softuni.socialnetwork.services.PostService;
import bg.softuni.socialnetwork.services.UserService;
import bg.softuni.socialnetwork.utils.UserUtils;
import static java.util.Comparator.comparing;

import java.sql.Date;


@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
	
		return "index";
	}
	

	@RequestMapping(value = UrlConstants.USER_HOME_PAGE , method = RequestMethod.GET)
	public String getUserInfo(Model model) {
		String user =UserUtils.getUser().getUsername();
		UserProfile currentUser = userService.getUsers(user).get(0);
		Long currentUserId = currentUser.getId();
		List<Post> posts = postService
			.getAllPostForUser(currentUserId); 
 
		model.addAttribute("user",currentUser);
		model.addAttribute("posts",posts);
		return "home";
	}
	
}
