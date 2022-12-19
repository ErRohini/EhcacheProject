package com.devtalkers.hibernate2levelcache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devtalkers.hibernate2levelcache.entity.Address;
import com.devtalkers.hibernate2levelcache.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> findByCityAndStreet(String City,String Street)
	{
		return addressRepository.findByCityAndStreet(City,Street);
	}

	public Address saveAddress(Address address) {
		
		return addressRepository.save(address);
	}
	  
}
	  
