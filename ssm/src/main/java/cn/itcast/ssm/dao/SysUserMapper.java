package cn.itcast.ssm.dao;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
	public int doLogin(@Param("username") String username,@Param("password") String password);
}
