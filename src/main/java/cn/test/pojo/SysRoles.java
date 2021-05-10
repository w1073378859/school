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
    * 角色表
    */
@Getter
@Setter
@ToString
public class SysRoles implements Serializable {
    /**
    * 角色编号
    */
    private Long id;

    /**
    * 角色名称
    */
    private String roleName;

    /**
    * 角色描述
    */
    private String description;

    /**
    * 是否锁定 1-->未锁定；2-->锁定
    */
    private Byte isLock;

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