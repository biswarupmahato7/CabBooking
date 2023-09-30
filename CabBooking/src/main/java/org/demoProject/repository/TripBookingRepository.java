package org.demoProject.repository;

import java.util.List;

import org.demoProject.model.TripBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer>{
	
//	public TripBooking addTripBooking(TripBooking tripBooking);
//
//	public TripBooking updateTripBooking(TripBooking tripBooking);
//
//	public TripBooking deleteTripBooking(Integer tripBookingId);

	@Query("from TripBooking where customer_id_customer_id =:customerId")
	public List<TripBooking> findByCustomerId(Integer customerId);
	
	@Query("from TripBooking order by customer_id_customer_id")
	public List<TripBooking> findtripscustomerwise();

	@Query("from TripBooking  order by fromDateTime")
	public List<TripBooking> findByFromdate_timeAsce();
	
	//@Query("from TripBooking where customerId=:customerId AND1 fromDateTime=date AND toDateTime=toDate")
	//public List<TripBooking> findByCustomerIdAndFromdate_time(Integer customerId, LocalDate date,LocalDate toDate);
	
	@Query("from TripBooking  ORDER by driver_id_driver_id")
	public List<TripBooking> findByDriverAsc();
	
	
	
}
