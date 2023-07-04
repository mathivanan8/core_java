package in.math.emo.exception.util;

import java.time.format.DateTimeFormatter;

import in.mathi.emo.exception.ValidationException;

public class StringUtil {
	public static void rejectIfInvalidString(String input, String inputType) throws ValidationException {

		if (input == null || "".equals(input.trim())) {
			throw new ValidationException(inputType.concat(" Cannot be null or Empty"));
		}
	}

	public static boolean isValid(String input) {

		if (input == null || "".equals(input.trim())) {
			return false;
		}
		return true;
	}

	public static boolean isInvalid(String input) {

		if (input == null || "".equals(input.trim())) {
			return true;
		}
		return false;

	}
	 public static DateTimeFormatter getDateTimeFormatter() {
	        return DateTimeFormatter.ofPattern("dd/MM/yy");
	    }
}
