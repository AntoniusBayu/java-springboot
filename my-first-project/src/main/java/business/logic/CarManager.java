package business.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataaccess.dao.CarDao;
import dataaccess.dbconnection.IUOW;
import dataaccess.model.Car2;

@Service
public class CarManager implements ICarManager{
	@Autowired
	private IUOW _uow;
	
	@Override
	public String createCar(Car2 data) {
		try 
		{
			_uow.openConnection();
			
			var x = new CarDao(_uow);
			
			_uow.begintran();
			
			x.save(data);
			
			_uow.committran();
			
			return "berhasil simpan";
		}
		catch(Exception ex)
		{
			_uow.rollback();
			return ex.getMessage();
		}
		finally
		{
			_uow.closeConnection();
		}
	}

	@Override
	public String updateCar(Car2 data) {
		try 
		{
			_uow.openConnection();
			
			var x = new CarDao(_uow);
			
			_uow.begintran();
			
			var currData = x.get(data.getCarID());
			currData.setCarName(data.getCarName());
			currData.setCreatedDate(data.getCreatedDate());
			
			x.update(currData);
			
			_uow.committran();
			
			return "berhasil simpan";
		}
		catch(Exception ex)
		{
			_uow.rollback();
			return ex.getMessage();
		}
		finally
		{
			_uow.closeConnection();
		}
	}

	@Override
	public String deleteCar(Car2 data) {
		try 
		{
			_uow.openConnection();
			
			var x = new CarDao(_uow);
			
			_uow.begintran();
			
			x.delete(data);
			
			_uow.committran();
			
			return "berhasil simpan";
		}
		catch(Exception ex)
		{
			_uow.rollback();
			return ex.getMessage();
		}
		finally
		{
			_uow.closeConnection();
		}
	}

	@Override
	public List<Car2> getAllCar() {
		try 
		{
			_uow.openConnection();
			
			var x = new CarDao(_uow);
		
			var y = x.getcarName();
			
			var data = x.getAllCar();
			data.get(0).setCarName(y);
			return data;
		}
		catch(Exception ex)
		{
			throw ex;
		}
		finally
		{
			_uow.closeConnection();
		}
	}

}
