package cn.test.service;

import cn.test.pojo.ChargeRecords;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface ChargeRecordsService{


int deleteByPrimaryKey(Long id);

int insert(ChargeRecords record);

int insertSelective(ChargeRecords record);

ChargeRecords selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(ChargeRecords record);

int updateByPrimaryKey(ChargeRecords record);

}
