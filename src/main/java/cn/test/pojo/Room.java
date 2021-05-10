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
    * 就诊房间表
    */
@Getter
@Setter
@ToString
public class Room implements Serializable {
    private Long id;

    /**
    * 就诊科室表主键ID
    */
    private Long departmentId;

    /**
    * 房间名称
    */
    private String rootName;

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