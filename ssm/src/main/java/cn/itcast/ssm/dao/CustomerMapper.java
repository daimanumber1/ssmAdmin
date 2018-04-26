package cn.itcast.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.itcast.ssm.pojo.BaseDict;
import cn.itcast.ssm.pojo.Customer;

public interface CustomerMapper {
	public List<Customer> findCustomerList();

	public List<Customer> test(@Param("a") String a, @Param("b") String b, @Param("c") String c, @Param("d") String d);

	public boolean deleteClient(String id);

	public int updateClient(@Param("id") String id, @Param("name") String name, @Param("source") String source,
			@Param("industry") String industry, @Param("level") String level, @Param("linkman") String linkman,
			@Param("phone") String phone, @Param("mobile") String mobile, @Param("zipcode") String zipcode,
			@Param("address") String address);
}
