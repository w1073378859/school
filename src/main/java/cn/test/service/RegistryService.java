package cn.test.service;

import cn.test.pojo.Registry;
import cn.test.util.result.Result;

import java.util.List;
import java.util.Map;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface RegistryService{


int deleteByPrimaryKey(Long id);

    boolean insert(Registry record);

    Result insertSelective(Registry record);

Registry selectByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(Registry record);

int updateByPrimaryKey(Registry record);

    List<Map<String,Object>> registryList(String idCard, Long departmentId, Long userId, Integer status);

    Map<String,Object> registryListById(Long id);

}
