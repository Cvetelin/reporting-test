package db;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import suites.AcceptanceTestSuite;
import suites.SanityTestSuite;
import utils.JdbcUtils;

@Category({SanityTestSuite.class, AcceptanceTestSuite.class})
public class DbConnectionTest {
	
	private Connection connection;

	@Test
	public void testConnection(){
		try{
			connection=JdbcUtils.openConnection();
			JdbcUtils.closeQuietly(connection);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to establish or close DB connection");
			
		}
		
	}
}
