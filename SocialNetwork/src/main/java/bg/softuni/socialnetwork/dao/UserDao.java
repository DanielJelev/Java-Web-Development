package bg.softuni.socialnetwork.dao;

import java.util.List;

import bg.softuni.socialnetwork.entity.UserProfile;


public interface UserDao {
	UserProfile getUser(String username);
	
	UserProfile getUserById(Long id);

	List<UserProfile> getUsers(String username);
	
	
	List<UserProfile> getFriends();
	
	boolean addUser(UserProfile user);
}