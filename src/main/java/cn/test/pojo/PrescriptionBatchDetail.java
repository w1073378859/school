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
    * 开药批次明细表
    */
@Getter
@Setter
@ToString
public class PrescriptionBatchDetail implements Serializable {
    private Long id;

    /**
    * 开药明细表主键ID
    */
    private Long prescriptionDetailId;

    /**
    * 药品批次表主键ID
    */
    private Long drugBatchId;

    /**
    * 用药数量
    */
    private Integer usedAmount;

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