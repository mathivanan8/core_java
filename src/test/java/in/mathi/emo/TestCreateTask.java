package in.mathi.emo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate; // Import LocalDate

import org.junit.jupiter.api.Test;

import in.mathi.emo.exception.ValidationException;
import in.mathi.emo.model.Task;
import in.mathi.emo.service.TaskService;

public class TestCreateTask {

	@Test
	public void testCreateTaskWithValidData() {
		TaskService taskService = new TaskService();

		Task newTask = new Task();

		String userInput = "27/07/2023";

		newTask.setTaskName("Open");
		LocalDate convertedDate = TaskService.convertToDate(userInput);
		newTask.setDueDate(convertedDate);

		assertDoesNotThrow(() -> {
			taskService.create(newTask);
		});

	}

	@Test
	public void testCreateTaskWithInvalidData() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {
			taskService.create(null);
		});
		String expectedMessage = "Invalid Task Input";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithTaskNameNull() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {

			Task newTask = new Task();

			newTask.setTaskID(12345);
			String userInput = "23/07/2023";

			newTask.setTaskName(null);
			LocalDate convertedDate = TaskService.convertToDate(userInput);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);

			taskService.create(newTask);
		});
		String expectedMessage = "Taskname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithTaskNameEmpty() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {

			Task newTask = new Task();

			String userInput = "23/07/2023";

			newTask.setTaskName("");
			LocalDate convertedDate = TaskService.convertToDate(userInput);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);

			taskService.create(newTask);
		});
		String expectedMessage = "Taskname cannot be Null or Empty";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

	@Test
	public void testCreateTaskWithInvalidDate() {
		TaskService taskService = new TaskService();
		Exception exception = assertThrows(ValidationException.class, () -> {

			Task newTask = new Task();

			newTask.setTaskID(99999);
			String userInput = "23/07/2022";

			newTask.setTaskName("Close The Door");
			LocalDate convertedDate = TaskService.convertToDate(userInput);
			newTask.setDueDate(convertedDate);
			newTask.setActive(true);

			taskService.create(newTask);
		});
		String expectedMessage = "Due Date can not be in the Past";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}

}