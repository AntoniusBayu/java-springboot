package dataaccess.model;

import java.time.Instant;
import java.time.ZonedDateTime;
import javax.persistence.*;

@Entity
@Table(name = "car_0")
public class Car2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long CarID;
	private String CarName;
	private Instant CreatedDate;
	private ZonedDateTime CreatedDateUS;
	private boolean IsActive;
	
	public Car2() {}
	
	public Car2(long _carId, String _name, Instant _date, ZonedDateTime _zone, boolean _isactive)
	{
		this.CarID = _carId;
		this.CarName = _name;
		this.CreatedDate = _date;
		this.CreatedDateUS = _zone;
		this.IsActive = _isactive;
	}
	
	public long getCarID() {
		return CarID;
	}
	
	public Instant getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Instant createdDate) {
		CreatedDate = createdDate;
	}
	public ZonedDateTime getCreatedDateUS() {
		return CreatedDateUS;
	}
	public void setCreatedDateUS(ZonedDateTime createdDateUS) {
		CreatedDateUS = createdDateUS;
	}
	public boolean isIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	public String getCarName() {
		return CarName;
	}
	public void setCarName(String carName) {
		CarName = carName;
	}
}
