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
    * 开药明细表
    */
@Getter
@Setter
@ToString
public class PrescriptionDetail implements Serializable {
    private Long id;

    /**
    * 药方表主键ID
    */
    private Long prescriptionId;

    /**
    * 挂号单表主键ID
    */
    private Long registryId;

    /**
    * 药品表主键ID
    */
    private Long drugId;

    /**
    * 病人表主键ID
    */
    private Long patientId;

    /**
    * 药品数量
    */
    private Integer amount;

    /**
    * 是否是医保用药 1-->不是医保用药，2-->是医保用药
    */
    private Byte isMedicare;

    /**
    * 药品原始价格
    */
    private BigDecimal price;

    /**
    * 实际支付价格
    */
    private BigDecimal payPrice;

    /**
    * 医保报销金额
    */
    private BigDecimal medicarePrice;

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