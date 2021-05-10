package cn.test.service;

import cn.test.pojo.SysMenus;
import cn.test.util.result.Result;

import java.util.List;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface SysMenusService{

    /**
     * @Author: W
     * @Date: 2021年03月84日 14时03分58秒
     * @Description: 根据所属id查询菜单列表
     * @param userId
     * @return java.util.List<cn.test.pojo.SysMenus>
     **/
     Result<List<SysMenus>> getMenusList(Integer userId);


}
