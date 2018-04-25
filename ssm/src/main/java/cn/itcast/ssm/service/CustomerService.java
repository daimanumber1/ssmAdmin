package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.pojo.BaseDict;
import cn.itcast.ssm.pojo.Customer;

public interface CustomerService {
	public List<Customer> findCustomerList();
	public List<Customer> test(String a,String b,String c,String d);
	public boolean deleteClient(String id);
}
