package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.pojo.BaseDict;

public interface SystemService {
	public List<BaseDict> findBaseDictListByType(String typeCode);
}
