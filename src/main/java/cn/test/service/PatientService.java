package cn.test.service;

import cn.test.pojo.Patient;
import cn.test.util.result.Result;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface PatientService{


int deleteByPrimaryKey(Long id);


int insertSelective(Patient record);

Patient selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(Patient record);

int updateByPrimaryKey(Patient record);

    /**
     * @Author: W
     * @Date: 2021年03月85日 16时03分10秒
     * @Description: 根据医保卡查询就诊卡
     * @param idMedicare
     * @return cn.test.pojo.Patient
     **/
    Patient getPatientByIdmed(String idMedicare);

    /**
     * @Author: W
     * @Date: 2021年03月85日 16时03分30秒
     * @Description: 根据身份证号查询就诊卡
     * @param idCard
     * @return cn.test.pojo.Patient
     **/
    Patient getPatientByIdCard(String idCard);

    /**
     * @Author: W
     * @Date: 2021年03月85日 17时03分17秒
     * @Description: 创建就诊卡
     * @param record
     * @return cn.test.util.result.Result
     **/
    Result insertPatient(Patient record);

}
