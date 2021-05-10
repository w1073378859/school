package cn.test.service;

import cn.test.pojo.SysRolesMenus;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface SysRolesMenusService{


int deleteByPrimaryKey(Long id);

int insert(SysRolesMenus record);

int insertSelective(SysRolesMenus record);

SysRolesMenus selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(SysRolesMenus record);

int updateByPrimaryKey(SysRolesMenus record);

}
