package MyLogger;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import MyLogger.FactoryLog.LevelLog;
import MyLogger.FactoryLog.WriteType;

public class DatabaseLog implements MyLogger {

	
//	private static DatabaseLog d;
//	
//	
//	public static DatabaseLog getIns() {
//		if(d == null) {
//			d = new DatabaseLog();
//		}
//		return d;
//	}
	
	
	
	@Override
	public void mylogMessage(LevelLog m, String message) throws SQLException {
		System.out.println("Connection + write in database" + message);
		
	
		
		//String SQL = "INSERT INTO Logger VALUES (?)";
      
		try {
			String SQL = "INSERT INTO Logger VALUES (?)";
			Connection con = DbConnect.getInstance().getConnection();
				
				PreparedStatement pstmt = con.prepareStatement(SQL);
				
		
		
				pstmt.setString(1, "[ "+Calendar.getInstance().getTime()+" ]" +"[ "+ m.name()+" ]"+ "[ "+ message+" ]");
				pstmt.executeUpdate();
				pstmt.close();
			
		} 
		catch (SQLException err) {
	        System.out.println(err.getMessage());
		
		}
		
	}

}
