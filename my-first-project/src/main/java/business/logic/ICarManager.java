package business.logic;

import java.util.List;
import dataaccess.model.Car2;

public interface ICarManager {
	String createCar(Car2 data);
	String updateCar(Car2 data);
	String deleteCar(Car2 data);
	List<Car2> getAllCar();
}
