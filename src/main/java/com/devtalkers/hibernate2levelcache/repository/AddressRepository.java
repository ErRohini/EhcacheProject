package com.devtalkers.hibernate2levelcache.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.devtalkers.hibernate2levelcache.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> 
{
	
	@QueryHints({@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")})
	List<Address> findByCityAndStreet(String City,String Street);

}
