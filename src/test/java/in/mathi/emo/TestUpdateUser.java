package in.mathi.emo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.mathi.emo.model.User;
import in.mathi.emo.service.UserService;

public class TestUpdateUser {

	@Test
	public void testUpdateUserServices() {

		UserService userService = new UserService();

		User updateUser = new User();

		updateUser.setFirstname("Gold");
		updateUser.setLastname("Berg");
		updateUser.setEmail("goldberg007@gmail.com");
		updateUser.setPassword("goldberg007@#1122");

		assertDoesNotThrow(() -> {

			userService.update(1, updateUser);
		});
	}

}
