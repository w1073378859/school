package cn.test.mapper;

import cn.test.pojo.SysMenus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**  
* @Package: mapper
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Mapper
@Repository
public interface SysMenusMapper {

    /**
     * @Author: W
     * @Date: 2021年03月84日 14时03分07秒
     * @Description: 根据所属id查询菜单列表
     * @param roleId
     * @return java.util.List<cn.test.pojo.SysMenus>
     **/
    List<SysMenus> getMenusList(@Param("roleId") Integer roleId);
}