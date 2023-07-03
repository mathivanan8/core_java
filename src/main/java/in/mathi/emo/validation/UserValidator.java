package in.mathi.emo.validation;

import in.math.emo.exception.util.StringUtil;
import in.mathi.emo.exception.ValidationException;
import in.mathi.emo.model.User;

import java.lang.Exception;

public class UserValidator {
    public static void Validate(User user) throws Exception {
    	//User value null
		if(user == null) {
			throw new ValidationException("Invalid user input");
		}
//		if("".equals(user.getEmailId().trim()) || user.getEmailId() == null) {
//			throw new ValidationException("Email cannot be empty or null");
//		}
//		if("".equals(user.getPassword().trim()) || user.getPassword() == null) {
//			throw new ValidationException("Password cannot be empty or null");
//		}
//		if("".equals(user.getFirstName().trim()) || user.getFirstName() == null) {
//			throw new ValidationException("Firstname cannot be empty or null");
//		}
		
		StringUtil.rejectIfInvalidString(user.getEmailId(), "Email");
		StringUtil.rejectIfInvalidString(user.getPassword(), "Password");
		StringUtil.rejectIfInvalidString(user.getFirstName(), "Firstname");
		
	}
}
