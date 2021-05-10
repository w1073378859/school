package cn.test.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

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
    * 挂号单表
    */
@Getter
@Setter
@ToString
public class Registry implements Serializable {
    private Long id;

    /**
    * 病人表主键ID
    */
    private Long patientId;

    /**
    * 排期表主键ID
    */
    private Long scheduleId;

    /**
    * 用户表主键ID
    */
    private Long userId;

    /**
    * 就诊科室表主键ID
    */
    private Long departmentId;

    /**
    * 就诊房间表主键ID
    */
    private Long roomId;

    /**
    * 挂号单状态 1-->已挂号，未问诊；2-->正在问诊；3-->问诊结束
    */
    private Byte status;

    /**
    * 挂号费(￥)
    */
    private BigDecimal fee;

    /**
    * 实际支付挂号费(￥)
    */
    private BigDecimal payFee;

    /**
    * 医保报销费(￥)
    */
    private BigDecimal medicareFee;

    /**
    * 是否使用医保卡 1-->未使用，2-->使用
    */
    private Byte isMedicare;

    /**
    * 挂号时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registryTime;

    /**
    * 医生问诊时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date consultationTime;

    /**
    * 创建时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    /**
    * 修改时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    private static final long serialVersionUID = 1L;
}