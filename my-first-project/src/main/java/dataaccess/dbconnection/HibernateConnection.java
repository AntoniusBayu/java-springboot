package dataaccess.dbconnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HibernateConnection implements IDBConnection {
	
	private SessionFactory  _sessionfactory;
	private Session _session;

	@Override
	public void openConnection() {
		if(_session == null)
		{
			this._sessionfactory = new Configuration().configure().buildSessionFactory();
			this._session = _sessionfactory.openSession();
		}
	}

	@Override
	public void closeConnection() {
		if(_session.isOpen())
		{
			_session.close();
			_sessionfactory.close();
			_session = null;
		}
	}
	
	public Session GetCurrentDBConnection()
	{
		if(_session.isOpen())
		{
			return _session;
		}
		else
		{
			return null;
		} 
	}
}
