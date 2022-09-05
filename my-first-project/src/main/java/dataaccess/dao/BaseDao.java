package dataaccess.dao;

import java.util.List;

import dataaccess.dbconnection.IUOW;
import dataaccess.model.car_0;

public abstract class BaseDao <T> implements IBaseDao<T>{
	
	private IUOW _uow;
	private Class<T> modelClass;
	
	public BaseDao(IUOW uow)
	{
		this._uow = uow;
	}
	
	public void setmodelClass(Class<T> modelClass) {
	    this.modelClass = modelClass;
	}
	
	@Override
	public T get(long id) {
		return this._uow.GetCurrentDBConnection().get(modelClass, id);
	}

	@Override
	public List<T> getAll() {
		return this._uow.GetCurrentDBConnection().createQuery("select * from " + modelClass.getName() + "", modelClass).list();
	}

	@Override
	public void save(T t) {
		this._uow.GetCurrentDBConnection().save(t);
	}

	@Override
	public void update(T t) {
		this._uow.GetCurrentDBConnection().update(t);
	}

	@Override
	public void delete(T t) {
		this._uow.GetCurrentDBConnection().delete(t);
	}
	
	public List<car_0> getAllCar() {
		return this._uow.GetCurrentDBConnection().createQuery("from car_0",car_0.class).list();
	}
	
	public String getcarName() {
		return this._uow.GetCurrentDBConnection().createQuery("select 'abc' as test").toString();
	}
}
