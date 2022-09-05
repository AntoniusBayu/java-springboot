package dataaccess.dbconnection;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitofWork implements IUOW {
	@Autowired
	private IDBConnection _conn;
	private Transaction _tran;
	
	@Override
	public void openConnection() {
		if(this._conn != null)
		{
			this._conn.openConnection();
		}
	}

	@Override
	public void closeConnection() {
		this._conn.closeConnection();
	}

	@Override
	public void begintran() {
		_tran = this._conn.GetCurrentDBConnection().beginTransaction();
	}

	@Override
	public void committran() {
		if (_tran != null && _tran.isActive())
		{
			_tran.commit();
		}
	}

	@Override
	public void rollback() {
		if (_tran != null && _tran.isActive())
		{
			_tran.rollback();
		}
	}

	@Override
	public Session GetCurrentDBConnection() {
		return this._conn.GetCurrentDBConnection();
	}

}
