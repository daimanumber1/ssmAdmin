package cn.itcast.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.ssm.dao.SysUserMapper;
import cn.itcast.ssm.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private SysUserMapper sysUserMapper;
	public int doLogin(String username, String password) {
		int i = sysUserMapper.doLogin(username, password);
		return i;
	}
	
}
