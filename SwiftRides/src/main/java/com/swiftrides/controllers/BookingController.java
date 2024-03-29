package com.swiftrides.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swiftrides.models.AddBooking;
import com.swiftrides.models.Booking;
import com.swiftrides.models.Ride;
import com.swiftrides.models.User;
import com.swiftrides.services.BookingService;
import com.swiftrides.services.RideService;
import com.swiftrides.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookingController 
{
	@Autowired
	BookingService bservice;
	
	@Autowired
	RideService rservice;
	
	@Autowired 
	UserService uservice;
	
	@GetMapping("/getAllBookings")
	public List<Booking> getAllBookings()
	{
		return bservice.getAllBookings();
	}
	
	@GetMapping("/getOneBooking")
	public Booking getOneBooking(@RequestParam("bid") int bid)
	{
		return bservice.getOneBooking(bid);
	}
	
	@GetMapping("/getOneBook/{bid}")
	public Booking getOneB(@PathVariable("bid") int bid)
	{
		return bservice.getOneBooking(bid);
	}
	
	@PostMapping("/addBooking")
	public Booking save(@RequestBody AddBooking addb)
	{
		User u=uservice.getUserId(addb.getPassenger_id());
		Ride r=rservice.getRideId(addb.getRide_id());
		
		LocalDateTime time=addb.getTime();
		int no_of_seats=addb.getNo_of_seats();
		int total_price=addb.getTotal_price();
		String Status=addb.getStatus();
		
		Booking b=new Booking(time, no_of_seats, total_price, Status, r, u);
		return bservice.saveBooking(b);
	}
	
	@GetMapping("/getTotalPrice")
	public int getTotalPrice(@RequestParam("bid") int bid)
	{
		return bservice.getTotalPrice(bid);
	}
	
	@GetMapping("/changeStatusAfterPayment")
	public int changeStatusAfterPayment(@RequestParam("bid") int bid)
	{
		return bservice.changeStatusAfterPayment(bid);
	}
	
	
	@GetMapping("/getAllBookingForUser")
	public List<Booking> getAllBookingForUser(@RequestParam("pid") User pid )
	{
		return bservice.getAllBookingForUser(pid);
	}
	
	
	
	
}

