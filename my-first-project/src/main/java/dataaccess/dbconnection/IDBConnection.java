package dataaccess.dbconnection;

import org.hibernate.Session;

public interface IDBConnection {
	void openConnection();
	void closeConnection();
	Session GetCurrentDBConnection();
}
