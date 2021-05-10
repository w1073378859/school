package cn.test.service;

import cn.test.pojo.Drug;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface DrugService{


int deleteByPrimaryKey(Long id);

int insert(Drug record);

int insertSelective(Drug record);

Drug selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(Drug record);

int updateByPrimaryKey(Drug record);

}
