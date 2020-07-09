package MachinePack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseCon {

		  private static DatabaseCon instance;
		  
		    private Connection connection;
		    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
		    private String username = "John";
		    private String password = "admin";

		    
		   
		    
		    public boolean onOff() throws SQLException {
		    	
		    	DatabaseCon.getInstance().getConnection();
		    	
		    	if(connection == null) {
		    		System.out.println("Connection is off");
		    		return false;
		    	}
		    	else
		    		System.out.println("Connection is on");
		    	
		    		return true;
		    		
		    }
		    
		  private  DatabaseCon() throws SQLException {
		        try {
		        	
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		            this.connection = DriverManager.getConnection(url, username, password);
		            
		        } catch (ClassNotFoundException ex) {
		            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		        }
		    }

		    public Connection getConnection() {
		        return connection;
		    }


		    
		    public static DatabaseCon getInstance() throws SQLException {
		        if (instance == null) {
		            instance = new DatabaseCon();
		        } 

		        return instance;
		    }
		
	
	
}
