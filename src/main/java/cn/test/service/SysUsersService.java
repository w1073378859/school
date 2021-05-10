package cn.test.service;

import cn.test.pojo.SysUsers;
import cn.test.util.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface SysUsersService{



    Result insert(SysUsers record, MultipartFile file);


    /**
     * @Author: W
     * @Date: 2021年03月82日 09时03分26秒
     * @Description: 查询用户密码
     * @param sysUsers
     * @return cn.test.pojo.SysUsers
     **/
    SysUsers queryByUsernameAndPassword(SysUsers sysUsers);

    /**
     * 根据用户名查询用户信息
     * @param account
     * @return
     */
    SysUsers getUserByAccount(String account);

    /**
     * 查询用户列表
     * @param sysUserReq
     * @return
     */
    List<SysUsers> getUsersList(SysUsers sysUserReq);

    /**
     * @Author: W
     * @Date: 2021年03月84日 11时03分38秒
     * @Description: 查询用户头像
     * @param userId
     * @return java.lang.String
     **/
    String getUserUrl(Integer userId);

    SysUsers getUserById(Long id);

    /**
     * @Author: W
     * @Date: 2021年03月85日 15时03分32秒
     * @Description: 文件上传方法
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @param file 文件原对象
     * @return void
     **/
    void uploadFile(String filePath, String fileName, MultipartFile file);

    /**
     * @Author: W
     * @Date: 2021年04月104日 09时04分00秒
     * @Description: 按科室查询医生
     * @param sysUsers
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    List<Map<String,Object>> getDoctorList(SysUsers sysUsers);
}
