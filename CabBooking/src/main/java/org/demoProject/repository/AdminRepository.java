package org.demoProject.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.demoProject.model.Admin;
import org.demoProject.model.TripBooking;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

//	public Admin addAdmin(Admin admin);
//
//	public Admin updateAdmin(Admin admin);
//
//	public Admin deleteAdmin(Integer adminId);
//
//	public Admin findById(Integer adminId);
//
//	public List<Admin> findAll();

//	public List<TripBooking> findAllTrips(Integer customerId);

//	public List<TripBooking> findAllTripsCabwise();
//
	@Query("from TripBooking order by customer_id_customer_id")
	public List<TripBooking> findAllTripsCustomerwise();
	
	
	@Query("from TripBooking order by from_date_time")
	public List<TripBooking> findAllTripsDatewise();
//
//	public List<TripBooking> findAllTripsForDays(Integer customerId, LocalDateTime fromDate, LocalDateTime toDate);
	
	@Query("from TripBooking where customer_id_customer_id=:customerId")
	public List<TripBooking> findByCustomerId(Integer customerId);
		
	public Admin findByuserName(String username);

}
