package cn.test.service.impl;

import cn.test.mapper.DrugBatchMapper;
import cn.test.pojo.DrugBatch;
import cn.test.service.DrugBatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class DrugBatchServiceImpl implements DrugBatchService{

    @Resource
    private DrugBatchMapper drugBatchMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return drugBatchMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DrugBatch record) {
        return drugBatchMapper.insert(record);
    }

    @Override
    public int insertSelective(DrugBatch record) {
        return drugBatchMapper.insertSelective(record);
    }

    @Override
    public DrugBatch selectByPrimaryKey(Long id) {
        return drugBatchMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DrugBatch record) {
        return drugBatchMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DrugBatch record) {
        return drugBatchMapper.updateByPrimaryKey(record);
    }

}
