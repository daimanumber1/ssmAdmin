package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.pojo.BaseDict;
import cn.itcast.ssm.pojo.Customer;

public interface CustomerService {
	public List<Customer> findCustomerList();
	public List<Customer> test(String a,String b,String c,String d);
	public boolean deleteClient(String id);
	public int updateClient(String id,String name, String source,
			String industry, String level, String linkman, String phone, String mobile, String zipcode,
			String address);
}
