package cn.test.mapper;

import cn.test.pojo.SysUsers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**  
* @Package: mapper
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Mapper
@Repository
public interface SysUsersMapper {

    /**
     * @Author: W
     * @Date: 2021年03月84日 14时03分20秒
     * @Description: 添加用户
     * @param record
     * @return int
     **/
    int insert(SysUsers record);
    /**
     * @Author: W
     * @Date: 2021年03月84日 14时03分47秒
     * @Description: 根据用户ID查询用户信息
     * @param id
     * @return cn.test.pojo.SysUsers
     **/
    SysUsers getUserById(@Param("id") Long id);
    /**
     * @Author: W
     * @Date: 2021年03月82日 09时03分08秒
     * @Description: 查询账号密码
     * @param sysUsers
     * @return cn.test.pojo.SysUsers
     **/
    SysUsers queryByUsernameAndPassword(SysUsers sysUsers);

    /**
     * @Author: W
     * @Date: 2021年03月82日 09时03分50秒
     * @Description: 根据用户名查询用户信息
     * @param account
     * @return cn.test.pojo.SysUsers
     **/
    SysUsers getUserByAccount(String account);

    /**
     * 查询用户列表
     * @param sysUserReq
     * @return
     */
    List<SysUsers> getUsersList(SysUsers sysUserReq);

    /**
     * @Author: W
     * @Date: 2021年03月84日 11时03分26秒
     * @Description: 查询用户头像
     * @param userId
     * @return java.lang.String
     **/
    String getUserUrl(Integer userId);

    /**
     * @Author: W
     * @Date: 2021年04月104日 09时04分37秒
     * @Description: 按科室查询医生
     * @param sysUsers
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    List<Map<String,Object>> getDoctorList(SysUsers sysUsers);
}