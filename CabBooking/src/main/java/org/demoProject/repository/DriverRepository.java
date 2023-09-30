package org.demoProject.repository;

import java.util.List;

import org.demoProject.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {

//	public Driver addDriver(Driver driver);
//
//	public Driver updateDriver(Driver driver);
//
//	public Driver deleteDriver(Integer driverId);
//
//	public Driver findById(Integer driverId);

//	public Driver validateDriver(Driver driver);
	
	public Driver findByUserName(String userName);

	@Query("from Driver d where d.rating>=4.5")
	public List<Driver> findBestDriver();
}
