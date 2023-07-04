package in.mathi.emo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.mathi.emo.exception.ValidationException;
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


		assertDoesNotThrow(() -> {

			userService.create(createUser);

		});

	}

	@Test
	public void testCreateUserWithInvalideInput() {

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
		
		Exception exception = assertThrows(ValidationException.class,() -> {

			userservice.create(createUser);

		});
		
			String expectedMessage = "Email Cannot be null or Empty";
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
		
		Exception exception = assertThrows(ValidationException.class,() -> {

			userservice.create(createUser);

		});
		
			String expectedMessage = "Email Cannot be null or Empty";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateUserWithPasswordNull() {

		UserService userservice = new UserService();
		
		User createUser = new User();
		createUser.setId(746);
		createUser.setFirstName("Mathi");
		createUser.setLastName("Vanan");
		createUser.setEmailId("mathizan16@gmail.com");
		createUser.setPassword(null);
		createUser.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class,() -> {

			userservice.create(createUser);

		});
		
			String expectedMessage = "Password Cannot be null or Empty";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateUserWithPasswordEmpty() {

		UserService userservice = new UserService();
		
		User createUser = new User();
		createUser.setId(746);
		createUser.setFirstName("Mathi");
		createUser.setLastName("Vanan");
		createUser.setEmailId("mathizan16@gmail.com");
		createUser.setPassword("");
		createUser.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class,() -> {

			userservice.create(createUser);

		});
		
			String expectedMessage = "Password Cannot be null or Empty";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateUserWithFirstNameNull() {

		UserService userservice = new UserService();
		
		User createUser = new User();
		createUser.setId(746);
		createUser.setFirstName(null);
		createUser.setLastName("Vanan");
		createUser.setEmailId("mathizan16@gmail.com");
		createUser.setPassword("Njcat#10van");
		createUser.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class,() -> {

			userservice.create(createUser);

		});
		
			String expectedMessage = "Firstname Cannot be null or Empty";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateUserWithFirstNameEmpty() {

		UserService userservice = new UserService();
		
		User createUser = new User();
		createUser.setId(746);
		createUser.setFirstName("");
		createUser.setLastName("Vanan");
		createUser.setEmailId("mathizan16@gmail.com");
		createUser.setPassword("Njcat#10van");
		createUser.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class,() -> {

			userservice.create(createUser);

		});
		
			String expectedMessage = "Firstname Cannot be null or Empty";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}

}
