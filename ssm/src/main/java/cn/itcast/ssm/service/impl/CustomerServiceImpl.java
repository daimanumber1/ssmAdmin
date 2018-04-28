package cn.itcast.ssm.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.ssm.dao.BaseDickMapper;
import cn.itcast.ssm.dao.CustomerMapper;
import cn.itcast.ssm.pojo.BaseDict;
import cn.itcast.ssm.pojo.Customer;
import cn.itcast.ssm.service.CustomerService;
import cn.itcast.ssm.service.SystemService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private BaseDickMapper baseDickMapper;

	public List<Customer> findCustomerList() {
		List<Customer> list = customerMapper.findCustomerList();
		for (Customer l : list) {
			BaseDict b1 = baseDickMapper.findBaseDictById(l.getCust_industry());
			BaseDict b2 = baseDickMapper.findBaseDictById(l.getCust_level());
			BaseDict b3 = baseDickMapper.findBaseDictById(l.getCust_source());
			l.setCust_industry(b1.getDict_item_name());
			l.setCust_level(b2.getDict_item_name());
			l.setCust_source(b3.getDict_item_name());
		}
		return list;
	}

	public List<Customer> test(String a, String b, String c, String d) {
		List<Customer> list = customerMapper.test(a, b, c, d);
		for (Customer l : list) {
			BaseDict b1 = baseDickMapper.findBaseDictById(l.getCust_industry());
			BaseDict b2 = baseDickMapper.findBaseDictById(l.getCust_level());
			BaseDict b3 = baseDickMapper.findBaseDictById(l.getCust_source());
			l.setCust_industry(b1.getDict_item_name());
			l.setCust_level(b2.getDict_item_name());
			l.setCust_source(b3.getDict_item_name());
		}
		return list;
	}

	public boolean deleteClient(String id) {
		boolean b = customerMapper.deleteClient(id);
		return b;
	}

	public int updateClient(String id, String name, String source, String industry, String level, String linkman,
			String phone, String mobile, String zipcode, String address) {
		BaseDict b1 = baseDickMapper.findBaseDickByItemName(level);
		BaseDict b2 = baseDickMapper.findBaseDickByItemName(source);
		BaseDict b3 = baseDickMapper.findBaseDickByItemName(industry);
		System.out.println(level+"-------");
		System.out.println(source+"--------");
		System.out.println(industry+"----------");
		level = b1.getDict_id();
		source = b2.getDict_id();
		industry = b3.getDict_id();
		System.out.println("level-----" + level);
		System.out.println("source-----" + source);
		System.out.println("industry-----" + industry);
		 int b = customerMapper.updateClient(id, name, source, industry, level,linkman, phone, mobile, zipcode, address);
		 return b;
//		return 0;
	}
}
