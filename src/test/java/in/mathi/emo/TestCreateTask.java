package in.mathi.emo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import in.mathi.emo.exception.ValidationException;
import in.mathi.emo.model.Task;
import in.mathi.emo.service.TaskService;

public class TestCreateTask {
	@Test
	public void testCreateTaskWithValidData() {

		TaskService TaskService = new TaskService();

		Task createTask = new Task();
		createTask.setName("Update");
		createTask.setDueDate("12-12-23");
		createTask.setId(746);
		createTask.setActive(true);


		assertDoesNotThrow(() -> {

			TaskService.create(createTask);

		});

	}
	@Test
	public void testCreateTaskWithInvalideInput() {

		TaskService TaskService = new TaskService();
		
		Exception exception = assertThrows(Exception.class, () -> {

			TaskService.create(null);

		});
		
			String expectedMessage = "Invalid task input";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateTaskWithNameNull() {

		TaskService Taskservice = new TaskService();
		
		Task createTask = new Task();
		createTask.setName(null);
		createTask.setDueDate("12-12-23");
		createTask.setId(746);
		createTask.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class,() -> {

			Taskservice.create(createTask);

		});
		
			String expectedMessage = "Name Cannot be null or Empty";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateTaskWithNameEmpty() {

		TaskService Taskservice = new TaskService();
		
		Task createTask = new Task();
		createTask.setName("");
		createTask.setDueDate("12-12-23");
		createTask.setId(746);
		createTask.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class,() -> {

			Taskservice.create(createTask);

		});
		
			String expectedMessage = "Name Cannot be null or Empty";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateTaskWithDueDateNull() {

		TaskService Taskservice = new TaskService();
		
		Task createTask = new Task();
		createTask.setName("Update");
		createTask.setDueDate(null);
		createTask.setId(746);
		createTask.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class,() -> {

			Taskservice.create(createTask);

		});
		
			String expectedMessage = "DueDate Cannot be null or Empty";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateTaskWithDueDateEmpty() {

		TaskService Taskservice = new TaskService();
		
		Task createTask = new Task();
		createTask.setName("Update");
		createTask.setDueDate("");
		createTask.setId(746);
		createTask.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class,() -> {

			Taskservice.create(createTask);

		});
		
			String expectedMessage = "DueDate Cannot be null or Empty";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateTaskWithDueDatePassedDate() {

		TaskService Taskservice = new TaskService();
		
		Task createTask = new Task();
		createTask.setName("Update");
		createTask.setDueDate("12-12-22");
		createTask.setId(746);
		createTask.setActive(true);
		
		Exception exception = assertThrows(ValidationException.class,() -> {

			Taskservice.create(createTask);

		});
		
			String expectedMessage = "Due date should be in the future";
			String receivedMessage = exception.getMessage();
			
			assertTrue(expectedMessage.equals(receivedMessage));

	}
	@Test
	public void testCreateUserWithDueDateParseDate() {
    	TaskService taskService = new TaskService();
    	Task newTask = new Task();
 		newTask.setId(1);
 		newTask.setDueDate("23/07/23"); //Date only dd-MM-yy
 		newTask.setName("Practice");
 		newTask.setActive(true);
		
		Exception exception = assertThrows(Exception.class,()->{
			taskService.create(newTask);
		});
		String expectedMessage = "Invalid date format. Expected format: dd-MM-yy";
		String actualMessage = exception.getMessage();
		
		assertTrue(expectedMessage.equals(actualMessage));
	}
	

}
