package com.altimetrik.ee.demo.service.impl;

import java.security.NoSuchAlgorithmException;

import com.altimetrik.ee.demo.entity.Customer;
import com.altimetrik.ee.demo.exception.AuthenticationFailedException;
import com.altimetrik.ee.demo.repository.CustomerDao;
import com.altimetrik.ee.demo.service.CustomerService;
import com.altimetrik.ee.demo.util.ShaHashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public Customer authentication(String username, String password)
			throws NoSuchAlgorithmException, AuthenticationFailedException {
		Customer customer = customerDao.findBy(username);
		if(customer.getPassword().equals(ShaHashing.encrypted(password)))
			return customer;
		else
			throw new AuthenticationFailedException();
	}

	@Override
	public Long addCustomer(Customer customer) throws NoSuchAlgorithmException {
		customer.setPassword(ShaHashing.encrypted(customer.getPassword()));
		return customerDao.save(customer);
	}

}
