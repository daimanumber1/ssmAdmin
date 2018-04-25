package cn.itcast.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.ssm.pojo.BaseDict;
import cn.itcast.ssm.pojo.Customer;

public interface CustomerMapper {
	public List<Customer> findCustomerList();
	public List<Customer> test(@Param("a") String a,@Param("b") String b,@Param("c") String c,@Param("d") String d);
	public boolean deleteClient(String id);
}
