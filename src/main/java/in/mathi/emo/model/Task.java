package in.mathi.emo.model;

import java.time.LocalDate;

public class Task extends TaskEntity {

	public Task(int taskID, String taskName, LocalDate dueDate, boolean isActive) {
		
		this.taskID = taskID;
		this.taskName = taskName;
		this.dueDate = dueDate;
		this.isActive = isActive;
	}

	public Task() {

	}

}