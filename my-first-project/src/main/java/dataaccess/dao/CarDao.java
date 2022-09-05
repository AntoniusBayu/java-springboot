package dataaccess.dao;

import dataaccess.dbconnection.IUOW;
import dataaccess.model.car_0;

public class CarDao extends BaseDao<car_0> {

	public CarDao(IUOW uow) {
		super(uow);

		this.setmodelClass(car_0.class);
	}
}
