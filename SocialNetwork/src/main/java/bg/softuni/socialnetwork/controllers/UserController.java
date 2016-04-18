package bg.softuni.socialnetwork.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dropbox.core.DbxException;

import bg.softuni.socialnetwork.entity.Post;
import bg.softuni.socialnetwork.entity.UserProfile;
import bg.softuni.socialnetwork.services.PostService;
import bg.softuni.socialnetwork.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage() {
		return "user-register";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(Model model, @ModelAttribute(value = "user") UserProfile user)throws NoSuchAlgorithmException, IOException, DbxException {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
	    String hashedPass = encoder.encodePassword(user.getPassword(), null);
	    int count = userService.getFriends().size();
	    user.setId(count+1);
	    user.setPassword(hashedPass);

		userService.addUser(user);

		return "home";
	}
	@RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
	public String userProfile(Model model ,@PathVariable String userId) {
		Long id = Long.parseLong(userId);
		UserProfile currentUser = userService.getUserById(id);
		
		model.addAttribute("user",currentUser);

		return "user-profile";
	}
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	public String userFriends(Model model) {
		List<UserProfile> friends = userService.getFriends();
		
		model.addAttribute("friends",friends);

		return "friends";
	}
	@RequestMapping(value = "/friend/profile/{userId}", method = RequestMethod.GET)
	public String friendProfile(Model model ,@PathVariable String userId) {
		Long friendId = Long.parseLong(userId);
		UserProfile currentUser = userService.getUserById(friendId);
		List<Post> posts = postService.getAllPostForUser(currentUser.getId());		
			
		model.addAttribute("user",currentUser);
		model.addAttribute("posts",posts);

		return "user-profile";
	}


}
