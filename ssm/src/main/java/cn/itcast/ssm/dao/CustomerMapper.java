package cn.itcast.ssm.dao;

import java.util.List;

import cn.itcast.ssm.pojo.BaseDict;
import cn.itcast.ssm.pojo.Customer;

public interface CustomerMapper {
	public List<Customer> findCustomerList();
}
