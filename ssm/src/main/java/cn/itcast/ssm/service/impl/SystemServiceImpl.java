package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.ssm.dao.BaseDickMapper;
import cn.itcast.ssm.pojo.BaseDict;
import cn.itcast.ssm.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService{
	@Autowired
	private BaseDickMapper baseDickMapper;
	public List<BaseDict> findBaseDictListByType(String typeCode) {
		List<BaseDict> list = baseDickMapper.findBaseDictListByType(typeCode);
		return list;
	}

}
