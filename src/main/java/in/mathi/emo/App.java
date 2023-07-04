package in.mathi.emo;

import in.mathi.emo.model.Task;
import in.mathi.emo.model.User;
import in.mathi.emo.service.TaskService;
import in.mathi.emo.service.UserService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UserService userService = new UserService();

			User createUser = new User();
			createUser.setId(746);
			createUser.setFirstName("Mathi");
			createUser.setLastName("Vanan");
			createUser.setEmailId("mathizan16@gmail.com");
			createUser.setPassword("Njcat#10van");
			createUser.setActive(true);

			userService.create(createUser);
			userService.getAll();
			
			TaskService TaskService = new TaskService();

			Task createTask = new Task();
			createTask.setName("Update");
			createTask.setDueDate("12-12-23");
			createTask.setId(746);
			createTask.setActive(true);

			TaskService.create(createTask);
			TaskService.getAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
