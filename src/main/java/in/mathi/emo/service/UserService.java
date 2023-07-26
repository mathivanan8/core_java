package in.mathi.emo.service;

import java.util.List;

import in.mathi.emo.dao.UserDAO;
import in.mathi.emo.exception.ValidationException;
import in.mathi.emo.model.User;
import in.mathi.emo.validation.UserValidator;

public class UserService {
	UserDAO userdao = new UserDAO();

	public User create(User user) throws Exception {

		UserValidator.validate(user);

		userdao.create(user);
		return user;

	}

	public int count() {
		return userdao.count();

	}

	public UserDAO update(int newId, User newUser) throws ValidationException {

		UserValidator.validate(newUser);

		userdao.update(newId, newUser);
		
		return userdao;

	}

	public void delete(int Id) {

		userdao.delete(Id);

	}

	public User findById(int newId) {

		return userdao.findById(newId);

	}

	public void findByEmail(String Email) {

		userdao.findByEmail(Email);

	}

	public List<User> getAll() {

		return userdao.findAll();

	}

}