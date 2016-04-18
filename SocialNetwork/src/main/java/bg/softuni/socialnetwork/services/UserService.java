package bg.softuni.socialnetwork.services;

import java.util.List;

import bg.softuni.socialnetwork.entity.UserProfile;

public interface UserService {
	List<UserProfile> getUsers(String username);
	List<UserProfile> getFriends();
	UserProfile getUserById(Long id);
	boolean addUser (UserProfile user);
}
