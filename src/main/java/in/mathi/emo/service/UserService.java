package in.mathi.emo.service;

import in.mathi.emo.dao.UserDAO;
import in.mathi.emo.model.User;

public class UserService {

	public User[] getAll() {

		UserDAO userDao = new UserDAO();

		User[] userList = userDao.findAll();

//		for (int i = 1; i < userList.length; i++) {

			System.out.println(userList[0]);

//		}
		return userList;

	}
	
	public void create() {
		
		User createUser = new User();
		createUser.setId(868686);
		createUser.setFirstName("Mathi");
		createUser.setLastName("Vanan");
		createUser.setEmailId("mathizan16@gmail.com");
		createUser.setPassword("Njcat#10van");
		createUser.setActive(true);
		
		UserDAO userDAO = new UserDAO();
		userDAO.create(createUser);
		
	}
}
