package org.demoProject.controller;

import java.util.List;

import org.demoProject.model.Driver;
import org.demoProject.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	
	//Adding driver

	@GetMapping("/adddriver")
	public String addDriver(Model model) {
		Driver driver = new Driver();
		model.addAttribute(driver);
		return "driver/adddriver";
	}

	@PostMapping("/adddriver")
	public String addDriverProcess(@ModelAttribute("driver") Driver driver, Model model) {
		Driver driver2 = driverService.addDriver(driver);
		if (driver2 == null) {
			return "driver/addunsuccess";
		} else {
			return "driver/addsuccess";
		}
	}
	
	//Updating Driver
	
	@GetMapping("/updatedriver")
	public String updateDriver(Model model) {
		Driver driver = new Driver();
		model.addAttribute("driver",driver);
		return "driver/updatedriver";
		
	}
	
	@PostMapping("/fetchupdatedriver")
	public String fetchUpdateDriver(@ModelAttribute("driver") Driver driver,Model model) {
		driver = driverService.findById(driver.getDriverId());
		if(driver == null) {
			return "driver/drivernotfound";
		}
		model.addAttribute("driver",driver);
		return "driver/driverupdatefound";
	}
	
	@PostMapping("/updatedriverprocess")
	public String updateDriverProcess(@ModelAttribute("driver") Driver driver,Model model) {
		Driver driver2 = driverService.updateDriver(driver);
		if(driver2 == null) {
			return "driver/updateunsuccess";
		}else {
			return "driver/updatesuccess";
		}
	}
	
	//Delete Driver

	@GetMapping("/deletedriver")
	public String deleteDriver(Model model) {
		Driver driver = new Driver();
		model.addAttribute("driver",driver);
		return "driver/deletedriver";
	}
	
	@PostMapping("/fetchdeletedriver")
	public String fetchDeleteDriver(@ModelAttribute("driver") Driver driver,Model model) {
		driver = driverService.findById(driver.getDriverId());
		if(driver == null) {
			return "driver/drivernotfound";
		}
		model.addAttribute("driver",driver);
		return "driver/driverdeletefound";
	}
	@PostMapping("/deletedriverprocess")
	public String deleteDriverProcess(@ModelAttribute("driver") Driver driver,Model model) {
		Driver driver2 = driverService.deleteDriver(driver.getDriverId());
		if(driver2 == null) {
			return "driver/deleteunsuccess";
		}else {
			return "driver/deletesuccess";
		}
	}
	@GetMapping("/listbestdrivers")
	public String listBestDriver(Model model) {
		List<Driver> list = driverService.getBestDrivers();
		if(list.isEmpty() == false) {
			model.addAttribute("list",list);
			return "driver/listbestdriver";
		}
		return "driver/addunsuccess";
	}
	
	@GetMapping("/listdrivers")
	public String listDriver(Model model) {
		List<Driver> list = driverService.findAll();
		if(list.isEmpty() == false) {
			model.addAttribute("list",list);
			return "driver/listdriver";
		}
		return "driver/addunsuccess";
	}
	
	
	
	@GetMapping("/finddriver")
	public String findDriver(Model model) {
		Driver driver = new Driver();
		model.addAttribute("driver",driver);
		return "driver/finddriver";
	}
	
	
	@PostMapping("/finddriver")
	public String findDriverProcess(@ModelAttribute("driver") Driver driver,Model model) {
		 driver = driverService.findById(driver.getDriverId());
		
		if(driver == null)
			return null;
		model.addAttribute(driver);
		return "driver/showdriver";
	}
	
	@GetMapping("/login")
	public String logindriver(Model model)
	{
		Driver driver=new Driver();
		model.addAttribute("driver",driver);
		return "driver/logindriver"; 
		
	}
	
	@PostMapping("/validdriver")
	public String validdriver(@ModelAttribute("driver") Driver driver,Model model)
	{
		if(driverService.validateDriver(driver.getUserName(),driver.getPassword())!=null)
			return "driver/profile"; //here add welcome $name then logged in
		else
			return "driver/profilenotfound";
	}
}
