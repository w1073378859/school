package cn.test.mapper;

import cn.test.pojo.SysRoles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**  
* @Package: mapper
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Mapper
public interface SysRolesMapper {

    /**
     * 查角色表
     * @return
     */
    List<SysRoles> getRoleList();


}