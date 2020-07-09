package MachinePack;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MachineSubject {

	private boolean onOff = false;
	
	private List<ObserverMachine> observers = new ArrayList<>();
	  private String message;

	  public void attach(ObserverMachine ObserverMachine){
	     observers.add(ObserverMachine);		
	  }

	  public void notifyAllObservers(){
	     for (ObserverMachine observer : observers) {
	        observer.update();
	     }
	  }

	  
	  public boolean isOnOff() {
			return onOff;
		}

		public void setOnOff(boolean onOff) {
			this.onOff = onOff;
		}

		
	  
		public void DatabaseCon() throws SQLException {
			
			if(onOff == true) {
				
//			DbConnect.getInstance();
				
				
	
				
			if(DatabaseCon.getInstance().onOff() == true) {
				
				setMessage("DataBase is on");
			}else
				setMessage("DataBase is off");
		}
			
		}
		
	
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
			 notifyAllObservers();
		} 	
	
}
