package cn.test.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**  
* @Package: dao
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/

/**
    * 用户表
    */

@Setter
@Getter
@ToString
public class SysUsers implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 就诊科室表主键ID
    */
    private Long departmentId;

    /**
    * 用户类型 1-->系统管理员；2-->挂号员；3-->门诊医师；4-->收银员；5-->药方医师
    */
    private Integer userType;

    /**
     * 角色名
     */
    private String userTypeName;

    /**
    * 用户头像URL
    */
    private String headUrl;

    /**
    * 账号
    */
    private String account;

    /**
    * 用户名
    */
    private String userName;

    /**
    * 密码
    */
    private String password;

    /**
    * 盐值
    */
    private String salt;

    /**
    * 创建时间
    */
    private Date createdTime;

    /**
    * 修改时间
    */
    private Date updatedTime;

    /**
    * 创建人
    */
    private Long createdUserId;

    private static final long serialVersionUID = 1L;


}