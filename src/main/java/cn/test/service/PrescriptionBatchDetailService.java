package cn.test.service;

import cn.test.pojo.PrescriptionBatchDetail;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface PrescriptionBatchDetailService{


int deleteByPrimaryKey(Long id);

int insert(PrescriptionBatchDetail record);

int insertSelective(PrescriptionBatchDetail record);

PrescriptionBatchDetail selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(PrescriptionBatchDetail record);

int updateByPrimaryKey(PrescriptionBatchDetail record);

}
