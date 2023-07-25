package in.mathi.emo.validation;


import in.math.emo.exception.util.StringUtil;
import in.mathi.emo.exception.ValidationException;
import in.mathi.emo.model.Task;

public class TaskValidator {
	public static void validate(Task newTask) throws ValidationException {

		if (newTask == null) {
			throw new ValidationException("Invalid Task Input");
		}

		StringUtil.rejectIfInvalidString(newTask.getTaskName(), "Taskname");
		StringUtil.rejectIfInvalidDate(newTask.getDueDate(), "Due Date");

	}

}