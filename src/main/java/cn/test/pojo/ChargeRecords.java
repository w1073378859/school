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
    * 收费记录表
    */
@Getter
@Setter
@ToString
public class ChargeRecords implements Serializable {
    private Long id;

    /**
    * 收费来源ID
    */
    private Long targetId;

    /**
    * 病人表主键ID
    */
    private Long patientId;

    /**
    * 收费来源类型 1-->药方；2-->检查单
    */
    private Byte targetType;

    /**
    * 支付方式 1-->现金；2-->支付宝；3-->微信
    */
    private Byte paymentMethod;

    /**
    * 总金额(￥)
    */
    private BigDecimal money;

    /**
    * 实际支付金额(￥)
    */
    private BigDecimal payMoney;

    /**
    * 医保报销金额(￥)
    */
    private BigDecimal medicareMoney;

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