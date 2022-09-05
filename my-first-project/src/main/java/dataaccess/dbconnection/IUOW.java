package dataaccess.dbconnection;

public interface IUOW extends IDBConnection{
	void begintran();
	void committran();
	void rollback();
}
