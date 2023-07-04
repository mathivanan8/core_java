package in.mathi.emo.validation;

import in.math.emo.exception.util.StringUtil;
import in.mathi.emo.exception.ValidationException;
import in.mathi.emo.model.Task;

import java.lang.Exception;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskValidator {
	private static LocalDate currentDate = LocalDate.now();

	public static void Validate(Task task) throws Exception {
		if (task == null) {
			throw new ValidationException("Invalid task input");
		}
		StringUtil.rejectIfInvalidString(task.getName(), "Name");
		StringUtil.rejectIfInvalidString(task.getDueDate(), "DueDate");

		if (!isValidDueDate(task.getDueDate())) {
			throw new ValidationException("DueDate must be a valid date");
		}
	}

	public static boolean isValidDueDate(String dueDate) {
		try {
			LocalDate parsedDueDate = LocalDate.parse(dueDate, StringUtil.getDateTimeFormatter());
			return parsedDueDate.isAfter(currentDate);
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}
