package in.mathi.emo.model;

public class Task {
	
	String name;
	String dueDate;
	boolean isActive = true;
	long id;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", dueDate=" + dueDate + ", isActive=" + isActive + ", id=" + id + "]";
	}

}
