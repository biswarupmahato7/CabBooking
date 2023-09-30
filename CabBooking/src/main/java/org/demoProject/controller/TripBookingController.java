package org.demoProject.controller;

import java.util.List;

import org.demoProject.model.Customer;
import org.demoProject.model.TripBooking;
import org.demoProject.model.TripBooking;
import org.demoProject.service.TripBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trip")
public class TripBookingController {

	@Autowired
	private TripBookingService tripbookingservice;
	
	
	@GetMapping("/addtrip")
	public String addtrip(Model model)
	{
		TripBooking trip=new TripBooking();
		model.addAttribute("trip",trip);
		return "tripbooking/addtrip";
	}
	
	@PostMapping("/addtrip")
	public String processaddtrip(@ModelAttribute("trip")TripBooking trip,Model model)
	{
		TripBooking tr=tripbookingservice.addTripBooking(trip);
		if(tr==null)
			return "tripbooking/addunsuccess";
		else
			return "tripbooking/addsuccess";
		}
	
	//Modify
	
		@GetMapping("/modifytrips")
		public String modifytrip(Model model)
		{
			TripBooking trip=new TripBooking();
			model.addAttribute("trip",trip);
			return "tripbooking/modifytrip";
		}
		
		@PostMapping("/fetchtrip")
		public String fetchtrip(@ModelAttribute("trip") TripBooking trip,Model model)
		{
			 trip=tripbookingservice.findById(trip.getTripBookingId());
			if(trip!=null)
			{
				model.addAttribute("trip",trip);
				return "tripbooking/fetchsuccess";
			}
			else
			{
				
				return "tripbooking/fetchunsuccess";
			}
		}
		
		@PostMapping("/modifytrip")
		public String processmodifytrip(@ModelAttribute("trip")TripBooking trip,Model model)
		{
			TripBooking tr=tripbookingservice.updateTripBooking(trip);
			if(tr!=null)
				return "tripbooking/modifysuccess";
			else
				return "tripbooking/modifyunsuccess";
		}
		
		
		//Delete
		
		@GetMapping("/deletetrip")
		public String deletetrip(Model model)
		{
			TripBooking trip=new TripBooking();
			model.addAttribute("trip",trip);
			return "tripbooking/deletetrip";
		}
		
		@PostMapping("/fetchdeletetrip")
		public String fetchfordeletetrip(@ModelAttribute("trip") TripBooking trip,Model model)
		{
		    trip=tripbookingservice.findById(trip.getTripBookingId());
			if(trip!=null)
			{
				model.addAttribute("trip",trip);
				return "tripbooking/fetchdeletesuccess";
			}
			else
			{
				
				return "tripbooking/fetchunsuccess";
			}
		}

		
		@PostMapping("/deletetrip")
		public String processdeletetrip(@ModelAttribute("trip") TripBooking trip)
		{
			TripBooking tr=tripbookingservice.deleteTripBooking(trip.getTripBookingId());
			if(tr!=null)
				return "tripbooking/deletesuccess";
			else
				return "tripbooking/deleteunsuccess";
		}
		
		//findbyid
		
		@GetMapping("/findtrip")
		public String findtripbooking(Model model)
		{
			TripBooking trip=new TripBooking();
			model.addAttribute("trip",trip);
			return "tripbooking/findtrip";
		}
		
		@PostMapping("/fetchtripdetails")
		public String fetchtripdetails(@ModelAttribute("trip") TripBooking trip,Model model)
		{
			trip=tripbookingservice.findById(trip.getTripBookingId());
			if(trip!=null)
			{
				model.addAttribute("trip",trip);
				return "tripbooking/findsuccess";
			}
			else
			{
				
				return "tripbooking/fetchunsuccess";
			}
		}
		
		//findlistoftrips
		@GetMapping("/tripsofcustomer")
		public String findtrips(Model model)
		{
			Customer customer=new Customer();
			model.addAttribute(customer);
			return "tripbooking/tripsofcustomer";
		}
		
		@PostMapping("/viewalltrips")
		public String viewtrips(@ModelAttribute("customer")Customer customer,Model model)
		{
			List<TripBooking> lists=tripbookingservice.findAllTrips(customer.getCustomerId());
			if(lists.size()>0)
			{
				model.addAttribute("lists",lists);
			    return "tripbooking/viewalltrips";
			}
			else
				return "tripbooking/fetchunsuccess";
		}
}
