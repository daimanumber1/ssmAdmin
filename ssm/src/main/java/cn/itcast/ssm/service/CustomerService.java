package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.pojo.BaseDict;

public interface CustomerService {
	public List<BaseDict> findBaseDictListByType(String typeCode);
}
