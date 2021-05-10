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
    * 医生排期表
    */
@Getter
@Setter
@ToString
public class Schedule implements Serializable {
    private Long id;

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
    * 值班时间段 1-->上午，2-->下午
    */
    private Byte sign;

    /**
    * 诊断病人数量
    */
    private Integer quantity;

    /**
    * 剩余诊断病人数量
    */
    private Integer remainingQuantity;

    /**
    * 问诊时间
    */
    private Date inquiryTime;

    /**
    * 创建时间
    */
    private Date createdTime;

    /**
    * 修改时间
    */
    private Date updatedTime;

    /**
     * @Author: W
     * @Date: 2021年03月88日 11时03分37秒
     * @Description: 医生名称
     * @param null
     * @return
     **/
    private String doctorName;

    /**
     * @Author: W
     * @Date: 2021年03月88日 12时03分10秒
     * @Description: 房间名称
     * @param null
     * @return
     **/
    private String roomName;

    private static final long serialVersionUID = 1L;
}