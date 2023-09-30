package org.demoProject.controller;

import java.util.List;

import org.demoProject.model.Admin;
import org.demoProject.model.Customer;
import org.demoProject.model.TripBooking;
import org.demoProject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminservice;
	
	
	//Add (correct code)
	@GetMapping("/addadmin")
	public String addadmin(Model model)
	{
		Admin admin=new Admin();
		model.addAttribute("admin",admin);
		return "admin/addadmin";
	}
	
	@PostMapping("/addadmin")
	public String processaddadmin(@ModelAttribute("admin")Admin admin)
	{
		if(adminservice.findAdminbyusername(admin.getUserName())==null)
		{
		  adminservice.addAdmin(admin);
		  return "admin/addsuccess";
		}
//		Admin adm=adminservice.addAdmin(admin);
//		if(adm==null)
		 return "admin/addunsuccess";	
	}
	
	//Modify
	
	@GetMapping("/modifyadmin")
	public String modifyadmin(Model model)
	{
		Admin admin=new Admin();
		model.addAttribute(admin);
		return "admin/modifyadmin";
	}
	
	@PostMapping("/fetchadmin")
	public String fetchadmin(@ModelAttribute("admin") Admin admin,Model model)
	{
		 admin=adminservice.findById(admin.getAdminId());
		if(admin!=null)
		{
			model.addAttribute("admin",admin);
			return "admin/fetchsuccess";
		}
		else
		{
			
			return "admin/fetchunsuccess";
		}
	}
	
	@PostMapping("/modifyadmin")
	public String processmodifyadmin(@ModelAttribute("admin") Admin admin)
	{
		Admin adm=adminservice.updateAdmin(admin);
		if(adm!=null)
			return "admin/modifysuccess";
		else
			return "admin/modifyunsuccess";
	}
	
	
	//Delete
	
	@GetMapping("/deleteadmin")
	public String deleteadmin(Model model)
	{
		Admin admin=new Admin();
		model.addAttribute(admin);
		return "admin/deleteadmin";
	}
	
	@PostMapping("/fetchdeleteadmin")
	public String fetchfordeleteadmin(@ModelAttribute("admin") Admin admin,Model model)
	{
	    admin=adminservice.findById(admin.getAdminId());
		if(admin!=null)
		{
			model.addAttribute("admin",admin);
			return "admin/fetchdeletesuccess";
		}
		else
		{
			
			return "admin/fetchunsuccess";
		}
	}

	
	@PostMapping("/deleteadmin")
	public String processdeleteadmin(@ModelAttribute("admin") Admin admin)
	{
		Admin adm=adminservice.deleteAdmin(admin.getAdminId());
		if(adm!=null)
			return "admin/deletesuccess";
		else
			return "admin/deleteunsuccess";
	}
//	@GetMapping("/delete/{adminId}") //works if we pass admin id through url
//	public String processdeleteadmin(@PathVariable("adminId")Integer adminId)
//	{
//		Admin adm=adminservice.deleteAdmin(adminId);
//		if(adm==null)
//			return "deleteunsuccess";
//		else
//			return "deletesuccess";
//	}
	
	//findtripsofcustomer
	
	@GetMapping("/tripsofcustomer")
	public String findtrips(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute(customer);
		return "admin/tripsofcustomer";
	}
	
	@PostMapping("/tripsofcustomer")
	public String viewtrips(@ModelAttribute("customer")Customer customer,Model model)
	{
		List<TripBooking> lists=adminservice.findAllTripsofcustomer(customer.getCustomerId());
		if(lists.size()>0)
		{
			model.addAttribute("lists",lists);
		    return "admin/viewalltrips";
		}
		else
			return "admin/fetchunsuccess";
	}
	
	//findtripscustomerwise
	
	@GetMapping("/viewtripscustomerwise")
	public String listtripsCustomers(Model model)
	{
		List<TripBooking> lists=adminservice.findAllTripsCustomerwise();
		if(lists.size()>0)
		{
			model.addAttribute("lists",lists);
			return "admin/listcustomertrips";
		}
		else
			return "admin/fetchunsuccess";
		
	}
	
	
	//findtripsdriverwise
	
	@GetMapping("/viewtripsdriverwise")
	public String listtripsDriver(Model model)
	{
		List<TripBooking> lists=adminservice.findAllTripsDriverwise();
		if(lists.size()>0)
		{
			model.addAttribute("lists",lists);
			return "admin/listdrivertrips";
		}
		else
			return "admin/fetchunsuccess";
		
	}
	
	
	@GetMapping("/viewtripsdatewise")
	public String listtripsbydate(Model model)
	{
		List<TripBooking> lists=adminservice.findAllTripsDatewise();
		if(lists.size()>0)
		{
			model.addAttribute("lists",lists);
			return "admin/tripsdatelist";
		}
		else
			return "admin/fetchunsuccess";
		
	}
	
	@GetMapping("/login")
	public String loginadmin(Model model)
	{
		Admin admin=new Admin();
		model.addAttribute("admin",admin);
		return "admin/loginadmin"; 
		
	}
	
	@PostMapping("/validadmin")
	public String validcustomer(@ModelAttribute("admin") Admin admin,Model model)
	{
		if(adminservice.validateAdmin(admin.getUserName(),admin.getPassword())!=null)
			return "admin/profile"; //here add welcome $name then logged in
		else
			return "admin/profilenotfound";
	}


}
