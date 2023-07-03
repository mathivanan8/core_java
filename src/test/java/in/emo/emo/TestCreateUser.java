package in.emo.emo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.mathi.emo.model.User;
import in.mathi.emo.service.UserService;

public class TestCreateUser {
	@Test
	public void testCreateUserWithValidData() {

		UserService userService = new UserService();

		User createUser = new User();
		createUser.setId(746);
		createUser.setFirstName("Mathi");
		createUser.setLastName("Vanan");
		createUser.setEmailId("mathizan16@gmail.com");
		createUser.setPassword("Njcat#10van");
		createUser.setActive(true);

		User createUser2 = new User();
		createUser2.setId(677);
		createUser2.setFirstName("mathi");
		createUser2.setLastName("vanan");
		createUser2.setEmailId("mathizan16@gmail.com");
		createUser2.setPassword("Njcat#10van");
		createUser2.setActive(true);

		assertDoesNotThrow(() -> {

			userService.create(createUser);
			userService.create(createUser2);

		});

	}

	@Test
	public void testCreateUserWithInavlideInput() {

		UserService userservice = new UserService();
		
		Exception exception = assertThrows(Exception.class, () -> {

			userservice.create(null);

		});
		
			String expectedMessage = "Invalid user input";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateUserWithEmailNull() {

		UserService userservice = new UserService();
		
		User createUser = new User();
		createUser.setId(746);
		createUser.setFirstName("Mathi");
		createUser.setLastName("Vanan");
		createUser.setEmailId(null);
		createUser.setPassword("Njcat#10van");
		createUser.setActive(true);
		
		Exception exception = assertThrows(Exception.class, () -> {

			userservice.create(createUser);

		});
		
			String expectedMessage = "Email cannot be empty or null";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateUserWithEmailEmpty() {

		UserService userservice = new UserService();
		
		User createUser = new User();
		createUser.setId(746);
		createUser.setFirstName("Mathi");
		createUser.setLastName("Vanan");
		createUser.setEmailId("");
		createUser.setPassword("Njcat#10van");
		createUser.setActive(true);
		
		Exception exception = assertThrows(Exception.class, () -> {

			userservice.create(createUser);

		});
		
			String expectedMessage = "Email cannot be empty or null";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}

}
