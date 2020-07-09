package MyLogger;

import java.sql.SQLException;

import MyLogger.FactoryLog.LevelLog;
import MyLogger.FactoryLog.WriteType;



public class FactoryLog {
	
   private FactoryLog() {
	
}
   
	private static FactoryLog f;
	private LevelLog l;
	private static WriteType w;
	
	public LevelLog getM() {
		return l;
	}

	public static void setW(WriteType w) {
		FactoryLog.getIns();
		FactoryLog.w = w;
		
	}
	
	
	public static  int functionGetLineNumber() {
		System.out.print("Line number : ");
	    int call = Thread.currentThread().getStackTrace()[1].getLineNumber();
	    System.out.println(call);
		return call;
}
	
	  public static int functionLine() {
	      return  FactoryLog.functionGetLineNumber();
	   }

	
	public static void setl(LevelLog l) {
		f.l = l;
	}
	
	public static FactoryLog getIns() {
		
		if(f == null)
		   f = new FactoryLog();
		return f;
}

	public static MyLogger  writeLog(LevelLog l, String message) throws SQLException {
		
		 {
		
		MyLogger log = null;
		
		switch(w) {
		
		case Database:
			
//		DatabaseLog.getIns().mylogMessage(w+" "+ message);
		
		log = new DatabaseLog();
		log.mylogMessage(l, message);
		break;
		
		
		case File:
			
			MyLogger lo = new WriteLog();
			lo.mylogMessage(l, message);
			
			break;
		
		case Console:
			log = new ConsoleLogger();
			log.mylogMessage(l, message);
			break;
		 }
		return null;
	}}
	

	
	public static enum LevelLog{
		ERROR, INFO, DEBUG;	
	}
	
	public static enum WriteType{
		Database, File, Console;
	}
}
