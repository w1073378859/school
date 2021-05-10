package cn.test.service;

import cn.test.pojo.SysRoles;

import java.util.List;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface SysRolesService{


    /**
     * 查询角色
     * @return
     */
    List<SysRoles> getRoleList();


}
