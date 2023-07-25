package in.mathi.emo.validation;

import in.math.emo.exception.util.StringUtil;
import in.mathi.emo.exception.ValidationException;
import in.mathi.emo.model.User;


public class UserValidator {

	public static void validate(User newUser) throws ValidationException {

		if (newUser == null) {
			throw new ValidationException("Invalid User Input");
		}

		StringUtil.rejectIfInvalidString(newUser.getEmail(), "Email");
		StringUtil.rejectIfInvalidString(newUser.getPassword(), "Password");
		StringUtil.rejectIfInvalidString(newUser.getFirstname(), "Firstname");

	}

}
