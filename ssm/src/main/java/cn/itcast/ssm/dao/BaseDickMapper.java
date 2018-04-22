package cn.itcast.ssm.dao;

import java.util.List;

import cn.itcast.ssm.pojo.BaseDict;

public interface BaseDickMapper {
	public List<BaseDict> findBaseDictListByType(String typeCode);
}
