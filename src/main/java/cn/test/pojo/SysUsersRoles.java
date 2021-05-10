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
    * 用户-角色关联表
    */
@Getter
@Setter
@ToString
public class SysUsersRoles implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 用户编号
    */
    private Long userId;

    /**
    * 角色编号
    */
    private Long roleId;

    /**
    * 创建时间
    */
    private Date createdTime;

    /**
    * 修改时间
    */
    private Date updatedTime;

    private static final long serialVersionUID = 1L;
}