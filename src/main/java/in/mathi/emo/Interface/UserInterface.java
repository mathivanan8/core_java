package in.mathi.emo.Interface;

import in.mathi.emo.model.User;

public interface UserInterface extends Base<User> {

	public abstract User findByEmail(String email);

	public abstract int count();

}