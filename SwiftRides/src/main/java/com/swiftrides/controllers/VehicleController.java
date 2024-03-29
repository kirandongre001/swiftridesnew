package com.swiftrides.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swiftrides.models.AddVehicle;
import com.swiftrides.models.Car_Model;
import com.swiftrides.models.User;
import com.swiftrides.models.Vehicle;
import com.swiftrides.services.Car_ModelService;
import com.swiftrides.services.UserService;
import com.swiftrides.services.VehicleService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class VehicleController {
	
		@Autowired
		VehicleService vservice;
		
		@Autowired 
		UserService userviService;
		
		@Autowired
		Car_ModelService cmservice;
		
		@PostMapping("/saveVehicle")
		public Vehicle save(@RequestBody AddVehicle addv)
		{
			Car_Model cm= cmservice.getCarModel(addv.getCarmodelid());
			User u= userviService.getUserId(addv.getUserid());
			int id=addv.getId();
			
			int year=addv.getYear();
			String color=addv.getColor();
			String rc_book=addv.getRc_book();
			
			Vehicle v=new Vehicle(year, color, rc_book, cm, u);
			return vservice.saveVehicle(v);
			//return vservice.saveVehicle(v);
		}
		
		@GetMapping("/getVehiclesFromUserid")
		public List<Vehicle> getVehicles(@RequestParam("uid")User uid)
		{
			return vservice.getVehicles(uid);
		}
	}
