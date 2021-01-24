package com.altimetrik.ee.demo.repository;


import com.altimetrik.ee.demo.entity.Customer;

public interface CustomerDao {

	Customer findBy(String username);
	Long save(Customer customer);
	
}
