package in.mathi.emo.validation;

import in.mathi.emo.model.User;

import java.lang.Exception;

public class UserValidator {
    public static void Validate(User user) throws Exception {
    	//User value null
		if(user == null) {
			throw new Exception("Invalid user input");
		}
		if("".equals(user.getEmailId().trim()) || user.getEmailId() == null) {
			throw new Exception("Email cannot be empty or null");
		}
		if("".equals(user.getPassword().trim()) || user.getPassword() == null) {
			throw new Exception("Password cannot be empty or null");
		}
		if("".equals(user.getFirstName().trim()) || user.getFirstName() == null) {
			throw new Exception("Firstname cannot be empty or null");
		}
	}
}
