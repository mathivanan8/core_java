package in.mathi.emo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import in.mathi.emo.model.Task;
import in.mathi.emo.service.TaskService;

public class TestGetAllTasks {
	@Test
	public void findById() {
		TaskService taskService = new TaskService();

		Task finalTask = taskService.findById(1);
		System.out.println(finalTask);

	}

	@Test
	public void getAllTasks() {
		TaskService taskService = new TaskService();
		System.out.println(taskService.getAll());

	}

	@Test
	public void findByDate() {
		TaskService taskService = new TaskService();
		String userInput2 = "31/07/2023";
		LocalDate convertedDate2 = TaskService.convertToDate(userInput2);
		List<Task> finalTask = taskService.getByDate(convertedDate2);
		System.out.println(finalTask);

	}

	@Test
	public void counting() {
		TaskService taskService = new TaskService();

		System.out.println(taskService.count());

	}
}