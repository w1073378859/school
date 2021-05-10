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
    * 药品批次表
    */
@Getter
@Setter
@ToString
public class DrugBatch implements Serializable {
    private Long id;

    /**
    * 药品表主键ID
    */
    private Long drugId;

    /**
    * 原始库存
    */
    private Integer stock;

    /**
    * 剩余库存
    */
    private Integer residueStock;

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