package in.mathi.emo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.math.emo.exception.util.ConnectionUtil;
import in.mathi.emo.Interface.UserInterface;
import in.mathi.emo.model.User;

public class UserDAO implements UserInterface {

	@Override
	public void create(User user) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO users (first_name, last_name, user_email, user_password) VALUES ( ?, ?, ?, ? );";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());

			ps.executeUpdate();

			System.out.println("User Successfully Created :");

		} catch (SQLException e) {
			if (e.getMessage().contains("Duplicate entry")) {
				throw new RuntimeException("Duplicate constraint");
			} else {
				System.out.println(e.getMessage());
				throw new RuntimeException(e);
			}

		} finally {
			ConnectionUtil.close(con, ps);
		}

	}

	public User findByEmail(String userEmail) {
		List<User> userList = UserList.ListOfUsers;
		User userMatch = null;

		for (User newUser : userList) {
			User user = newUser;

			if (user == null) {
				System.out.println("User Details is Not There");
				break;
			}
			if (user.getEmail().equals(userEmail)) {
				userMatch = user;
				break;
			}
		}
		System.out.println(userMatch);
		return userMatch;
	}

	@Override
	public void delete(int newId) {
		List<User> userList2 = UserList.ListOfUsers;
		for (User newUser : userList2) {
			User user1 = newUser;

			if (user1 == null) {
				continue;
			}
			if (user1.getId() == newId) {
				user1.setActive(false);

			}

		}

	}

	@Override
	public int count() {
		List<User> userList3 = UserList.ListOfUsers;
		int count = 0;
		for (User newUser : userList3) {
			User user1 = newUser;
			count++;
		}
		return count;
	}

	@Override
	public void update(int id, User newUser) {
		List<User> userList = UserList.ListOfUsers;

		Iterator<User> iterator = userList.iterator();
		while (iterator.hasNext()) {
			User existingUser = iterator.next();
			if (existingUser.getId() == id) {
				iterator.remove();
				userList.add(newUser);
				break;
			}
		}
	}

	public User findById(int userId) throws RuntimeException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User matchedUser = null;

		try {
			String query = "SELECT * FROM users WHERE id = ? AND is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			if (rs.next()) {
				matchedUser = new User();
				matchedUser.setId(rs.getInt("id"));
				matchedUser.setFirstname(rs.getString("first_name"));
				matchedUser.setLastname(rs.getString("last_name"));
				matchedUser.setEmail(rs.getString("user_email"));
				matchedUser.setActive(rs.getBoolean("is_active"));
				matchedUser.setPassword(rs.getString("user_password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		System.out.println(matchedUser);
		return matchedUser;
	}

	// JDBC Connections

	public List<User> findAll() throws RuntimeException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<User> userList = new ArrayList<User>();

		try {
			String query = "SELECT * from users where is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				User newUser = new User();
				newUser.setId(rs.getInt("id"));
				newUser.setFirstname(rs.getString("first_name"));
				newUser.setLastname(rs.getString("last_name"));
				newUser.setEmail(rs.getString("user_email"));
				newUser.setActive(rs.getBoolean("is_active"));
				newUser.setPassword(rs.getString("user_password"));

				userList.add(newUser);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);

		} finally {

			ConnectionUtil.close(con, ps);

		}

		return userList;

	}

}