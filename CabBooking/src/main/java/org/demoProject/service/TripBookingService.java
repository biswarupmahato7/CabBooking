package org.demoProject.service;

import java.util.List;

import org.demoProject.model.TripBooking;
import org.springframework.stereotype.Service;


@Service
public interface TripBookingService {
	public TripBooking addTripBooking(TripBooking tripBooking);

	public TripBooking updateTripBooking(TripBooking tripBooking);

	public TripBooking deleteTripBooking(Integer tripBookingId);
	
	public TripBooking findById(Integer tripBookingId);

	public List<TripBooking> findAllTrips(Integer customerId);

//	public TripBooking findBill(Integer customerId);
}
