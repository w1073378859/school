package cn.test.service.impl;

import cn.test.mapper.DrugMapper;
import cn.test.pojo.Drug;
import cn.test.service.DrugService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class DrugServiceImpl implements DrugService{

    @Resource
    private DrugMapper drugMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return drugMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Drug record) {
        return drugMapper.insert(record);
    }

    @Override
    public int insertSelective(Drug record) {
        return drugMapper.insertSelective(record);
    }

    @Override
    public Drug selectByPrimaryKey(Long id) {
        return drugMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Drug record) {
        return drugMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Drug record) {
        return drugMapper.updateByPrimaryKey(record);
    }

}
