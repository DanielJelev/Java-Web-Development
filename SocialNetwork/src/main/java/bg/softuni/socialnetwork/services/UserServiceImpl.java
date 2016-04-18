package bg.softuni.socialnetwork.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.softuni.socialnetwork.dao.UserDao;
import bg.softuni.socialnetwork.entity.UserProfile;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserProfile> getUsers(String username) {
		return userDao.getUsers(username);
	}

	@Override
	public boolean addUser(UserProfile user) {
		userDao.addUser(user);
		return false;
	}

	@Override
	public List<UserProfile> getFriends() {
		return userDao.getFriends();
		
	}

	@Override
	public UserProfile getUserById(Long id) {
		return userDao.getUserById(id);
		
	}
}