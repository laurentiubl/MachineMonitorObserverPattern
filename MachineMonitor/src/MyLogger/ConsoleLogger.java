package MyLogger;

import java.sql.SQLException;

import MyLogger.FactoryLog.LevelLog;

public class ConsoleLogger implements MyLogger {

	@Override
	public void mylogMessage(LevelLog l, String message) throws SQLException {
		System.out.println(l.name() + "il nostro messaggio: " + message);
		
	}

}
