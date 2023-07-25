package in.math.emo.exception.util;

import java.sql.*;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {

	public static Connection getConnection() {

		Dotenv env = Dotenv.load();

		String url = env.get("DATABASE_HOST");
		String username =  env.get("DATABASE_USERNAME");
		String password =  env.get("DATABASE_PASSWORD");
		
		Connection connection = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);


		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return connection;
	}

	public static void close(Connection connection, PreparedStatement ps) {

		try {

			if (ps != null) {

				ps.close();
			}
			if (connection != null) {

				connection.close();

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public static void close(Connection connection, PreparedStatement ps, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
