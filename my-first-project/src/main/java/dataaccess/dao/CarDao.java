package dataaccess.dao;

import dataaccess.dbconnection.IUOW;
import dataaccess.model.Car2;

public class CarDao extends BaseDao<Car2> {

	public CarDao(IUOW uow) {
		super(uow);

		this.setmodelClass(Car2.class);
	}
}
