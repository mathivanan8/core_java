package in.mathi.emo;

import in.mathi.emo.model.User;
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

//		userService.update();
			userService.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
