package cn.test.service;

import cn.test.pojo.SysUsersRoles;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface SysUsersRolesService{


int deleteByPrimaryKey(Long id);

int insert(SysUsersRoles record);

int insertSelective(SysUsersRoles record);

SysUsersRoles selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(SysUsersRoles record);

int updateByPrimaryKey(SysUsersRoles record);

}
