package cn.test.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**  
* @Package: dao
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/

/**
    * 药品表
    */
@Getter
@Setter
@ToString
public class Drug implements Serializable {
    private Long id;

    /**
    * 药品名称
    */
    private String name;

    /**
    * 生产厂家
    */
    private String company;

    /**
    * 单价
    */
    private BigDecimal price;

    /**
    * 药品图片URL
    */
    private String image;

    /**
    * 药品类型 1-->甲类；2-->乙类；3-->丙类
    */
    private Byte type;

    /**
    * 生产日期
    */
    private Date productionDate;

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