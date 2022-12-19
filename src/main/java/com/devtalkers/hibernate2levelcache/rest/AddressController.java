package com.devtalkers.hibernate2levelcache.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devtalkers.hibernate2levelcache.entity.Address;
import com.devtalkers.hibernate2levelcache.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/address/{city}/{street}")
	public ResponseEntity<List<Address>> getAddressByCityAndStreet(@PathVariable("city") String city,@PathVariable("street") String street)
	{
		return new ResponseEntity<>(addressService.findByCityAndStreet(city, street) ,HttpStatus.OK);
	}

	@PostMapping("/address")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address)
	{
		return new ResponseEntity<Address>(addressService.saveAddress(address),HttpStatus.CREATED);
	}
}
