package in.mathi.emo.validation;

import java.lang.Exception;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import in.math.emo.exception.util.StringUtil;
import in.mathi.emo.exception.ValidationException;
import in.mathi.emo.model.Task;

public class TaskValidator {
    public static void Validate(Task task) throws Exception {
        if (task == null) {
            throw new ValidationException("Invalid task input");
        }
        StringUtil.rejectIfInvalidString(task.getName(), "Name");
        StringUtil.rejectIfInvalidString(task.getDueDate(), "DueDate");
        String date = task.getDueDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        LocalDate dueDate = LocalDate.parse(date, formatter);
        LocalDate currentDate = LocalDate.now();
        if (dueDate.equals(currentDate) || dueDate.isBefore(currentDate)) {
            throw new ValidationException("Due date should be in the future");
        }
		
    }
}