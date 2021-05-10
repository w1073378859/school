package cn.test.pojo;

import cn.test.pojo.dto.SysSubMenuDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**  
* @Package: dao
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/

/**
    * 菜单表
    */
@Getter
@Setter
@ToString
public class SysMenus implements Serializable {
    /**
    * 编号
    */
    private Long id;

    /**
    * 菜单名称
    */
    private String menuName;

    /**
    * 菜单URL
    */
    private String menuUrl;

    /**
    * 菜单类型 1-->1级菜单；2-->2级菜单
    */
    private Integer menuType;

    /**
    * 父级菜单编号
    */
    private Long parentId;

    /**
    * 创建时间
    */
    private Date createdTime;

    /**
    * 修改时间
    */
    private Date updatedTime;

    /**
     * 子菜单
     */
    private List<SysSubMenuDto> subMenus;

    private static final long serialVersionUID = 1L;


}