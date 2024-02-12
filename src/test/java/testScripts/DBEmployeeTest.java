package testScripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DBEmployeeTest {
	 static Connection con = null;
	  private static Statement stmt;
	  public static String DB_URL ="jdbc:sqlite:C://Users//nandhana.sri/testTrgDB.db";
	  public static String DB_USER = "";
	  public static String DB_PASSWORD = "";
	  
	  @BeforeTest
	  public void setUp() throws Exception{
		  try {
			  Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			  stmt = con.createStatement();
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  @Test
	  public void test()
	  {
		  try {
			 
			  
			  String query1 ="SELECT emp_name FROM Employee WHERE emp_id IN (SELECT emp_id FROM emp_dep WHERE dept_id IN (SELECT dept_id FROM Department WHERE dept_name = 'HR'))";
		        ResultSet res1 = stmt.executeQuery(query1);

		        // Iterate through the ResultSet to retrieve the results
		        while (res1.next()) {
		            System.out.println(res1.getString("emp_name"));
		        }
			  
			  
		  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
		  
		  }
	  
	  @AfterTest
	  public void tearDown() throws Exception
	  {
		  if(con!=null)
		  {
			  con.close();
		  }
	  }
}
