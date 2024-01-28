package JDBCwithDAO;




import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;




public class DatabaseConnection {

	private static Connection con = null;

	static
	{
		
		try {
		Properties p=new Properties();
		InputStream Ip=new FileInputStream("database.properties");
		
		p.load(Ip);
		String Driver=p.getProperty("Driver");
		String url=p.getProperty("url");
		String name=p.getProperty("name");
		String pswd=p.getProperty("pswd");
		
		Class.forName(Driver);
		
		con=DriverManager.getConnection(url,name,pswd);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public static Connection getConnection()
	{
		return con;
	}
}

			
			
