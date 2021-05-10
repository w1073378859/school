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
    * 角色-菜单关联表
    */
@Getter
@Setter
@ToString
public class SysRolesMenus implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 角色编号
    */
    private Long roleId;

    /**
    * 菜单编号
    */
    private Long menuId;

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