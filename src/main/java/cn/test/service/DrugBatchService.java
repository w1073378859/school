package cn.test.service;

import cn.test.pojo.DrugBatch;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface DrugBatchService{


int deleteByPrimaryKey(Long id);

int insert(DrugBatch record);

int insertSelective(DrugBatch record);

DrugBatch selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(DrugBatch record);

int updateByPrimaryKey(DrugBatch record);

}
