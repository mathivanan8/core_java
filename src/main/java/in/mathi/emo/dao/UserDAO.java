package in.mathi.emo.dao;

import in.mathi.emo.model.User;

public class UserDAO {

	public User[] findAll() {

		User[] userList = UserList.listOfUsers;
		return userList;
	}

	public void create(User createUser) {
		
		UserList.listOfUsers[0] = createUser;
	}

}
