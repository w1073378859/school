package cn.test.service.impl;

import cn.test.mapper.PrescriptionBatchDetailMapper;
import cn.test.pojo.PrescriptionBatchDetail;
import cn.test.service.PrescriptionBatchDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class PrescriptionBatchDetailServiceImpl implements PrescriptionBatchDetailService{

    @Resource
    private PrescriptionBatchDetailMapper prescriptionBatchDetailMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return prescriptionBatchDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PrescriptionBatchDetail record) {
        return prescriptionBatchDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(PrescriptionBatchDetail record) {
        return prescriptionBatchDetailMapper.insertSelective(record);
    }

    @Override
    public PrescriptionBatchDetail selectByPrimaryKey(Long id) {
        return prescriptionBatchDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PrescriptionBatchDetail record) {
        return prescriptionBatchDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PrescriptionBatchDetail record) {
        return prescriptionBatchDetailMapper.updateByPrimaryKey(record);
    }

}
