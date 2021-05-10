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
    * 药方表
    */
@Getter
@Setter
@ToString
public class Prescription implements Serializable {
    private Long id;

    /**
    * 挂号单表主键ID
    */
    private Long registryId;

    /**
    * 病人表主键ID
    */
    private Long patientId;

    /**
    * 支付状态 1-->待支付；2-->支付成功；3-->支付失败；4-->超时未支付
    */
    private Byte payStatus;

    /**
    * 是否取药 1-->未取药；2-->已取药
    */
    private Byte isFetchMedicine;

    /**
    * 总金额(￥)
    */
    private BigDecimal fee;

    /**
    * 实际支付金额(￥)
    */
    private BigDecimal payFee;

    /**
    * 医保报销金额(￥)
    */
    private BigDecimal medicareFee;

    /**
    * 支付时间
    */
    private Date payTime;

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