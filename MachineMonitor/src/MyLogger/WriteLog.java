package MyLogger;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import MyLogger.FactoryLog.LevelLog;

public class WriteLog implements MyLogger {
	
	static int b;
	
	@Override
	public void mylogMessage(LevelLog l, String message) {
		
	
		
			    try
			    { 
		    	
			    	File logger = new File("C:\\Users\\Blg-John\\Desktop\\File\\Logger.txt");
			    	
			    	if(!logger.exists()) {
			    		logger.createNewFile();
			    	}
			    	
			      BufferedWriter outputWriter = null;
			      FileWriter fileWritter = new FileWriter(logger, true);
			      
				  outputWriter = new BufferedWriter(fileWritter);
				b++;
			outputWriter.write(b+ " "+l.name()+" Message: "+ message+ Calendar.getInstance().getTime());
			outputWriter.newLine();
			outputWriter.flush();
				
					  outputWriter.close();  
			    }
			    catch(IOException e)
			    {
			      e.printStackTrace();
			    }
			   
			  }
	

}
