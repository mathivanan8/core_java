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

		User newUser = new User();

		//newUser.setId(12345);
		newUser.setFirstname("Mathi");
		newUser.setLastname("Vanan");
		newUser.setEmail("mathizan16@gmail.com");
		newUser.setPassword("Njcat#10");
		//newUser.setActive(true);

		assertDoesNotThrow(() -> {
			userService.create(newUser);
		});

	}

	@Test
	public void testCreateUserWithInvalidData() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			userService.create(null);
		});
		String expectedMessage = "Invalid User Input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithEmailNull() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {

			User newUser = new User();

			newUser.setId(12345);
			newUser.setFirstname("Mathi");
			newUser.setLastname("Vanan");
			newUser.setEmail(null);
			newUser.setPassword("Njcat#10");
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "Email cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithEmailEmpty() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {

			User newUser = new User();

			newUser.setId(12345);
			newUser.setFirstname("Mathi");
			newUser.setLastname("Vanan");
			newUser.setEmail("");
			newUser.setPassword("Njcat#10");
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "Email cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithPasswordEmpty() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {

			User newUser = new User();

			newUser.setId(12345);
			newUser.setFirstname("Mathi");
			newUser.setLastname("Vanan");
			newUser.setEmail("mathizan16@gmail.com");
			newUser.setPassword("");
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "Password cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithPasswordNull() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {

			User newUser = new User();

			newUser.setId(12345);
			newUser.setFirstname("Mathi");
			newUser.setLastname("Vanan");
			newUser.setEmail("mathizan16@gmail.com");
			newUser.setPassword(null);
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "Password cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithFirstnameEmpty() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {

			User newUser = new User();

			newUser.setId(12345);
			newUser.setFirstname("");
			newUser.setLastname("Vanan");
			newUser.setEmail("mathizan16@gmail.com");
			newUser.setPassword("Njcat#10");
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "Firstname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateUserWithFirstnameNull() {
		UserService userService = new UserService();
		Exception exception = assertThrows(ValidationException.class, () -> {

			User newUser = new User();

			newUser.setId(12345);
			newUser.setFirstname(null);
			newUser.setLastname("Vanan");
			newUser.setEmail("mathizan16@gmail.com");
			newUser.setPassword("Njcat#10");
			newUser.setActive(true);

			userService.create(newUser);
		});
		String expectedMessage = "Firstname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@Test
	public void testCreateUserWithExistingEmail() {
		UserService userService = new UserService();
		Exception exception = assertThrows(RuntimeException.class, () -> {

			User newUser = new User();

		
			newUser.setFirstname("Mathi");
			newUser.setLastname("Vanan");
			newUser.setEmail("mathizan16@gmail.com");
			newUser.setPassword("Njcat#10");
		

			userService.create(newUser);
		});
		String expectedMessage = "Duplicate constraint";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

}