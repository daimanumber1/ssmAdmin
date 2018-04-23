package cn.itcast.ssm.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.itcast.ssm.dao.CustomerMapper;
import cn.itcast.ssm.pojo.Customer;
import cn.itcast.ssm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;

	public List<Customer> findCustomerList() {
		List<Customer> list = customerMapper.findCustomerList();
		return list;
	}
}
