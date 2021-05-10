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
    * 医嘱表
    */
@Getter
@Setter
@ToString
public class MedicalAdvice implements Serializable {
    private Long id;

    /**
    * 挂号单表主键ID
    */
    private Long registryId;

    /**
    * 就诊医师用户ID
    */
    private Long userId;

    /**
    * 病人主诉
    */
    private String chiefComplaint;

    /**
    * 诊断情况
    */
    private String diagnosis;

    /**
    * 创建时间
    */
    private Date createdTime;

    /**
    * 修改时间
    */
    private Date updatedTime;

    private String doctorName;

    private static final long serialVersionUID = 1L;
}