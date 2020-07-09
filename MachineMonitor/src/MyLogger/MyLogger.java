package MyLogger;

import java.sql.SQLException;

import MyLogger.FactoryLog.LevelLog;

public interface MyLogger {

	public void mylogMessage(LevelLog l ,String message) throws SQLException;

}
