package cn.test.service.impl;

import cn.test.mapper.RegistryMapper;
import cn.test.pojo.Registry;
import cn.test.service.RegistryService;
import cn.test.util.result.Result;
import cn.test.util.result.ResultUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class RegistryServiceImpl implements RegistryService{

    @Resource
    private RegistryMapper registryMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return registryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public boolean insert(Registry record) {
        return registryMapper.insert(record)>0?true:false;
    }

    @Override
    public Result insertSelective(Registry record) {

        return registryMapper.insertSelective(record)>0? ResultUtils.returnSuccess():ResultUtils.returnFail();
    }

    @Override
    public Registry selectByPrimaryKey(Long id) {
        return registryMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Registry record) {
        return registryMapper.updateByPrimaryKeySelective(record)>0?true:false;
    }

    @Override
    public int updateByPrimaryKey(Registry record) {
        return registryMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String,Object>> registryList(String idCard,Long departmentId,Long userId,Integer status){
        return registryMapper.registryList(idCard,departmentId,userId,status);
    }

    @Override
    public Map<String, Object> registryListById(Long id) {
        return registryMapper.registryListById(id);
    }

}
