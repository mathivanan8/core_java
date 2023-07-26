package in.mathi.emo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import in.mathi.emo.service.TaskService;

public class TestDeleteTask {
	@Test
	public void testUpdateUserWithValidData() {
		TaskService taskService = new TaskService();

		assertDoesNotThrow(() -> {
			taskService.delete(3);
		});

	}

}