package in.mathi.emo.dao;

import in.mathi.emo.model.User;

public class UserDAO {

	public User[] findAll() {

		User[] userList = UserList.listOfUsers;
		return userList;
	}

	public void create() {

		User createUser = new User();
		createUser.setId(868686);
		createUser.setFirstName("Mathi");
		createUser.setFirstName("Vanan");
		createUser.setEmailId("mathizan16@gmail.com");
		createUser.setPassword("Njcat#10van");
		createUser.setActive(true);
		
		UserList.listOfUsers[0] = createUser;
	}

}
