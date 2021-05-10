package cn.test.service;

import cn.test.pojo.PrescriptionDetail;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface PrescriptionDetailService{


int deleteByPrimaryKey(Long id);

int insert(PrescriptionDetail record);

int insertSelective(PrescriptionDetail record);

PrescriptionDetail selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(PrescriptionDetail record);

int updateByPrimaryKey(PrescriptionDetail record);

}
