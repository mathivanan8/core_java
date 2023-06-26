package in.mathi.emo.service;

import in.mathi.emo.dao.UserDAO;
import in.mathi.emo.model.User;

public class UserService {

	public User[] getAll() {

		UserDAO userDao = new UserDAO();

		User[] userList = userDao.findAll();

		for (int i = 1; i < userList.length; i++) {
			
			System.out.println(userList[i]);

		}
		return userList;

	}

}
