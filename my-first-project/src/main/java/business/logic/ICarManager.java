package business.logic;

import java.util.List;
import dataaccess.model.car_0;

public interface ICarManager {
	String createCar(car_0 data);
	String updateCar(car_0 data);
	String deleteCar(car_0 data);
	List<car_0> getAllCar();
}
