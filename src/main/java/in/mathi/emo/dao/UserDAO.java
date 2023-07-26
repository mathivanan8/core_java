package in.mathi.emo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

	public int count() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		List<User> userList = new ArrayList<User>();
		try {
			String query = "SELECT * FROM users Where is_active = 1";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}
		return count;

	}
	
	@Override
	public void delete(int newId) {
	    Connection con = null;
	    PreparedStatement ps = null;

	    try {
	        String query = "UPDATE users SET is_active = false WHERE id = ?";
	        con = ConnectionUtil.getConnection();
	        ps = con.prepareStatement(query);
//	        ps.setBoolean(1, false);
	        ps.setInt(1, newId);

	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("User with ID " + newId + " set as inactive.");
	        } else {
	            System.out.println("User with ID " + newId + " not found.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	        throw new RuntimeException(e);
	    } finally {
	        ConnectionUtil.close(con, ps);
	    }
	}


	@Override
	public void update(int id, User newUser) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "UPDATE users SET first_name = ?,last_name = ? Where id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, newUser.getFirstname());
			ps.setString(2, newUser.getLastname());
			ps.setInt(3, id);

			ps.executeUpdate();

			System.out.println("User Successfully Updated");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		} finally {
			ConnectionUtil.close(con, ps);
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