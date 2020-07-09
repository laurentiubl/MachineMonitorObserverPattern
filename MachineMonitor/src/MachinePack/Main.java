package MachinePack;
import java.sql.SQLException;

import MyLogger.FactoryLog;
import MyLogger.FactoryLog.LevelLog;
import MyLogger.FactoryLog.WriteType;

public class Main {

	public static void main(String[] args) throws SQLException, InterruptedException {
		
		
		MachineSubject Subject = new MachineSubject();
		new Display(Subject);
		Subject.setOnOff(true);
		
		
		boolean b = true;
		while(b) {
		

			
			if(Subject.isOnOff() == false) {
				Subject.setMessage("The machine is closed, please turn On");
				b = false;
			}
				 try {
						
					 Subject.DatabaseCon();			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 FactoryLog.setW(WriteType.Database);
		
		 
   		 FactoryLog.writeLog(LevelLog.INFO, " Attention!! ");
//			
//		
			
//			 FactoryLog.functionLine();
		
			
			Thread.sleep(10000);
		}
	  }
}
