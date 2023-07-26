package in.mathi.emo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.mathi.emo.model.User;
import in.mathi.emo.service.UserService;

public class TestDeleteUser {
	
	@Test
	public void testDeleteUser() {
		
		UserService userService = new UserService();
		
		User deleteUser = new User();
		
		
		deleteUser.setActive(false);
		
		assertDoesNotThrow(() -> {
			
			userService.delete(1);
		});
	}

}
