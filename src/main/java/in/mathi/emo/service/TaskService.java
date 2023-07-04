package in.mathi.emo.service;

import in.mathi.emo.dao.TaskDAO;
import in.mathi.emo.model.Task;
import in.mathi.emo.validation.TaskValidator;

public class TaskService {
	
	public Task[] getAll() {

		TaskDAO TaskDao = new TaskDAO();

		Task[] TaskList = TaskDao.findAll();

		for (int i = 0; i < TaskList.length; i++) {

			System.out.println(TaskList[i]);

		}
		return TaskList;

	}
	
	public void create(Task createTask) throws Exception{
		
		TaskValidator.Validate(createTask);
		TaskDAO TaskDAO = new TaskDAO();
		TaskDAO.create(createTask);
		
	}
	
	public void update() {
	 
		Task updateTask = new Task();
		
		TaskDAO TaskDao = new TaskDAO();
		TaskDao.update(677 , updateTask);
	}
	
	public void delete(int taskId) {
 		TaskDAO TaskDao = new TaskDAO();
 		TaskDao.delete(1);
 	}
	
	public void findById() {
		 
		Task updateTask = new Task();
		
		TaskDAO TaskDao = new TaskDAO();
		TaskDao.update(677 , updateTask);
	}

}
