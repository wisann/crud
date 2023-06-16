package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);

			} catch (SQLException e) {
				throw new MyException(e.getMessage());
			}
		}
		return conn;
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new MyException(e.getMessage());
		}

	}

	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new MyException("erro ao fechar resul set");
		}

	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			throw new MyException("erro ao fechar conexão");
		}
	}

	public static void closePreparedStatement(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			throw new MyException("erro ao fechar prepared statement");
		}
	}
}
