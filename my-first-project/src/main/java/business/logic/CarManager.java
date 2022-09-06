package business.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dataaccess.dao.CarDao;
import dataaccess.dbconnection.IUOW;
import dataaccess.model.car_0;

@Service
public class CarManager implements ICarManager{
	@Autowired
	private IUOW _uow;
	
	@Override
	public String createCar(car_0 data) {
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
	public String updateCar(car_0 data) {
		try 
		{
			_uow.openConnection();
			
			var x = new CarDao(_uow);
			
			_uow.begintran();
			
			var currData = x.get(data.getCarid());
			currData.setCarname(data.getCarname());
			currData.setCreateddate(data.getCreateddate());
			
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
	public String deleteCar(car_0 data) {
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
	public List<car_0> getAllCar() {
		try 
		{
			_uow.openConnection();
			
			var x = new CarDao(_uow);
		
			var data = x.getAll();
			
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
