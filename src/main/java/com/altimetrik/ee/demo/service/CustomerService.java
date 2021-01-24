package com.altimetrik.ee.demo.service;

import com.altimetrik.ee.demo.entity.Customer;
import com.altimetrik.ee.demo.exception.AuthenticationFailedException;

import java.security.NoSuchAlgorithmException;

public interface CustomerService {

	Customer authentication(String username, String password)
			throws NoSuchAlgorithmException, AuthenticationFailedException;
	Long addCustomer(Customer customer) throws NoSuchAlgorithmException;
}
