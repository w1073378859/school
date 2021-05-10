package cn.test.service;

import cn.test.pojo.MedicalAdvice;
import org.apache.ibatis.annotations.Param;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface MedicalAdviceService{


int deleteByPrimaryKey(Long id);

int insert(MedicalAdvice record);

/**
 * @Author: W
 * @Date: 2021年04月115日 14时04分09秒
 * @Description: 添加医嘱
 * @param record
 * @return boolean
 **/
    boolean insertSelective(MedicalAdvice record) throws Exception;

MedicalAdvice selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(MedicalAdvice record);

int updateByPrimaryKey(MedicalAdvice record);

    MedicalAdvice medicalAdviceById(@Param("rId") Long rId);

}
