package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.dao.BaseDickMapper;
import cn.itcast.ssm.pojo.BaseDict;
import cn.itcast.ssm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private BaseDickMapper baseMapper;
	public List<BaseDict> findBaseDictListByType(String typeCode) {
		List<BaseDict> list = baseMapper.findBaseDictListByType(typeCode);
		return list;
	}
}
