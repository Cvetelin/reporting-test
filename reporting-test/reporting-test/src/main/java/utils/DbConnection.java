package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.rules.ExternalResource;

public class DbConnection extends ExternalResource{

	private Connection connection;
	private static String dbDriver;
	private static String dbUrl;
	private static String dbUsername;
	private static String dbPassword;
	public static String filePath;
	
	@Override
	protected void before() throws Throwable {
		connection = JdbcUtils.openConnection();
	}

	@Override
	protected void after() {
		JdbcUtils.closeQuietly(connection);
	}

	public Connection getConnection() {
		return connection;
	}

	static {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			URL url = Thread.currentThread().getContextClassLoader().getResource("test.properties"); //$NON-NLS-1$
			//filePath = new File(url.getPath()).getCanonicalPath().replaceAll("%20", " "); //$NON-NLS-1$ //$NON-NLS-2$
			input = new FileInputStream(url.getPath());
			prop.load(input);
			dbDriver = prop.getProperty("DRIVER");
			dbUrl= prop.getProperty("DB_URL");
			dbUsername = prop.getProperty("DB_USERNAME");
			dbPassword = prop.getProperty("DB_PASSWORD");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Connection openConnection() throws Exception {
		Class.forName(dbDriver);
		return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	}
	
	public static void closeQuietly(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// Not interested of
			}
		}
	}
}
