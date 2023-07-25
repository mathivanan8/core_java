package in.mathi.emo;

import in.mathi.emo.model.User;
import in.mathi.emo.service.UserService;

import org.junit.jupiter.api.Test;

public class TestGetAllUsers {

	@Test
	public void testGetAllUsers() {

		UserService userService = new UserService();
		System.out.println(userService.getAll());

	}

	@Test
	public void findById() {
		UserService userFindId = new UserService();

		User user = userFindId.findById(1);

		System.out.println(user);
//		return user;

	}

}
