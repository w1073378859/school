package cn.test.service.impl;

import cn.test.mapper.ChargeRecordsMapper;
import cn.test.pojo.ChargeRecords;
import cn.test.service.ChargeRecordsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class ChargeRecordsServiceImpl implements ChargeRecordsService{

    @Resource
    private ChargeRecordsMapper chargeRecordsMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return chargeRecordsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ChargeRecords record) {
        return chargeRecordsMapper.insert(record);
    }

    @Override
    public int insertSelective(ChargeRecords record) {
        return chargeRecordsMapper.insertSelective(record);
    }

    @Override
    public ChargeRecords selectByPrimaryKey(Long id) {
        return chargeRecordsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ChargeRecords record) {
        return chargeRecordsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ChargeRecords record) {
        return chargeRecordsMapper.updateByPrimaryKey(record);
    }

}
