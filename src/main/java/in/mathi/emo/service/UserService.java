package in.mathi.emo.service;

import in.mathi.emo.dao.UserDAO;
import in.mathi.emo.model.User;
import in.mathi.emo.validation.UserValidator;

public class UserService {

	public User[] getAll() {

		UserDAO userDao = new UserDAO();

		User[] userList = userDao.findAll();

		for (int i = 0; i < userList.length; i++) {

			System.out.println(userList[i]);

		}
		return userList;

	}
	
	public void create(User createUser) throws Exception{
		
		UserValidator.Validate(createUser);
		UserDAO userDAO = new UserDAO();
		userDAO.create(createUser);
		
	}
	
	public void update() {
	 
		User updateUser = new User();
		
		UserDAO userDao = new UserDAO();
		userDao.update(677 , updateUser);
	}
	
	public void findById() {
		 
		User updateUser = new User();
		
		UserDAO userDao = new UserDAO();
		userDao.update(677 , updateUser);
	}
}
