package cn.itcast.ssm.dao;

import java.util.List;

import cn.itcast.ssm.pojo.BaseDict;

public interface CustomerMapper {
	public List<BaseDict> findBaseDictListByType(String typeCode);
}
