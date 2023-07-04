package in.mathi.emo.dao;

import in.mathi.emo.model.Task;

public class TaskDAO {

	public Task[] findAll() {

		Task[] taskList = TaskList.listOfTasks;
		return taskList;

	}

	public void create(Task createTask) {

		Task[] arr = TaskList.listOfTasks;

		for (int i = 0; i < arr.length; i++) {
			Task user1 = arr[i];
			if (user1 == null) {
				arr[i] = createTask;
				break;
			}
		}

	}

	public void update(int newId, Task updateTask) {

		Task[] arr = TaskList.listOfTasks;

		for (int i = 0; i < arr.length; i++) {
			Task user = arr[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == newId) {

				arr[i].setName(updateTask.getName());
				arr[i].setDueDate(updateTask.getDueDate());

			}
		}

	}

	public void delete(int taskId) {

		Task[] arr = TaskList.listOfTasks;

		for (int i = 0; i < arr.length; i++) {
			Task user = arr[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == taskId) {
				user.setActive(false);
				break;
			}
		}
	}

	public Task findById(int taskId) {
		Task[] arr = TaskList.listOfTasks;
		Task userMatch = null;
		for (int i = 0; i < arr.length; i++) {
			Task user = arr[i];
			if (user == null) {
				continue;
			}
			if (user.getId() == taskId) {
				userMatch = user;
				break;
			}
		}
		return userMatch;
	}

}
