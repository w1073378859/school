package cn.test.service;

import cn.test.pojo.Prescription;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface PrescriptionService{


int deleteByPrimaryKey(Long id);

int insert(Prescription record);

int insertSelective(Prescription record);

Prescription selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(Prescription record);

int updateByPrimaryKey(Prescription record);

}
