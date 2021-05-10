package cn.test.pojo;

import cn.test.util.util.DateUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**  
* @Package: dao
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/

/**
    * 病人表
    */
@Getter
@Setter
@ToString
public class Patient implements Serializable {
    private Long id;

    /**
    * 病人姓名
    */
    private String name;

    /**
    * 出生日期
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
    * 性别 1-->女性，2-->男性
    */
    private Byte sex;

    /**
    * 家庭住址
    */
    private String address;

    /**
    * 联系方式
    */
    private String phone;

    /**
    * 身份证号
    */
    private String idCard;

    /**
    * 是否有医保卡 1-->没有，2-->有
    */
    private Byte isMedicare;

    /**
    * 医保卡号
    */
    private String idMedicare;

    /**
    * 创建时间
    */
    private Date createdTime;

    /**
    * 修改时间
    */
    private Date updatedTime;

    private static final long serialVersionUID = 1L;

    public void setBirthday(String birthday) {

        this.birthday = DateUtils.getCurrentDate(birthday);
    }
}