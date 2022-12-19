package com.devtalkers.hibernate2levelcache.repository;

import com.devtalkers.hibernate2levelcache.entity.City;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
