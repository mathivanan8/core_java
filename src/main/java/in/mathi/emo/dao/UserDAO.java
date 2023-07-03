package in.mathi.emo.dao;

import in.mathi.emo.model.User;

public class UserDAO {

	public User[] findAll() {

		User[] userList = UserList.listOfUsers;
		return userList;
	}

	/**
	 * 
	 * @param createUser
	 */
	public void create(User createUser) {

		User[] arr = UserList.listOfUsers;

		for (int i = 0; i < arr.length; i++) {
			User user1 = arr[i];
			if (user1 == null) {
				arr[i] = createUser;
				break;
			}
		}
	}

	public void update(int newId, User updateUser) {

		User[] arr = UserList.listOfUsers;

		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == newId) {

				arr[i].setFirstName(updateUser.getFirstName());
				arr[i].setLastName(updateUser.getLastName());
				arr[i].setPassword(updateUser.getPassword());

			}
		}
	}

	public void delete(int userId) {

		User[] arr = UserList.listOfUsers;

		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if(user == null){
				continue;
			}
			if (user.getId() == userId) {
				user.setActive(false);
				break;
			}
		}
	}
	
	public User findById(int userId) {
		User[] arr = UserList.listOfUsers;
		User userMatch = null;
		for (int i = 0; i < arr.length; i++) {
			User user = arr[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == userId) {
				userMatch = user;
				break;
			}
	   }
		return userMatch;
	}

}
