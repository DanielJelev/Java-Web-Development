package bg.softuni.socialnetwork.entity;

//@Entity
//@Table(name = "USER_AUTHORITY")
public class UserAuthority {

	private UserProfile user;
	private Authority authority;

	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
}
