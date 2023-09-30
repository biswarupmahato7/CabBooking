package org.demoProject.service;

import java.util.List;

import org.demoProject.model.Driver;
import org.springframework.stereotype.Service;

@Service
public interface DriverService {
	public Driver addDriver(Driver driver);

	public Driver updateDriver(Driver driver);

	public Driver deleteDriver(Integer driverId);

	public List<Driver> getBestDrivers();

	public Driver findById(Integer driverId);

	public List<Driver> findAll();

	public Driver validateDriver(String username, String password);

	public Driver findByUserName(String userName);

}
