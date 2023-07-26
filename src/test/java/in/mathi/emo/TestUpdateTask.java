package in.mathi.emo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import in.mathi.emo.model.Task;
import in.mathi.emo.service.TaskService;

public class TestUpdateTask {
	@Test
	public void testUpdateUserWithValidData(){
		TaskService taskService = new TaskService();

		Task newTask = new Task();

		String userInput = "27/07/2023";

		newTask.setTaskName("Open the Door");
		LocalDate convertedDate = TaskService.convertToDate(userInput);
		newTask.setDueDate(convertedDate);

		assertDoesNotThrow (() -> {
			taskService.update(1,newTask );
		});

	}

}