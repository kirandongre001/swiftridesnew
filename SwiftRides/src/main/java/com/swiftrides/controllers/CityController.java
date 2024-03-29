package com.swiftrides.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swiftrides.models.City;
import com.swiftrides.models.State;
import com.swiftrides.services.CityService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CityController 
{
	@Autowired
	CityService cservice;
	@GetMapping("/getCities")
	public List<City> getAllCities()
	{
		return cservice.getAllcities();
	}
	
	@GetMapping("/getcity")
	public City getOneCity(@RequestParam("cityid") int cityid)
	{
		return cservice.getCity(cityid);
	}
	
	@GetMapping("/getOneCity/{cid}")
	public City getOne(@PathVariable("cid")int cityid)
	{
		return cservice.getCity(cityid);
	}
	
	@GetMapping("/getcitiesfromstate")
	public List<City> getCities(@RequestParam("sid")State stateid)
	{
		return cservice.getCities(stateid);
	}
	
	
	
}

