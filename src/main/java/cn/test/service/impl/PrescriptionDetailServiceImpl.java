package cn.test.service.impl;

import cn.test.mapper.PrescriptionDetailMapper;
import cn.test.pojo.PrescriptionDetail;
import cn.test.service.PrescriptionDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class PrescriptionDetailServiceImpl implements PrescriptionDetailService{

    @Resource
    private PrescriptionDetailMapper prescriptionDetailMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return prescriptionDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PrescriptionDetail record) {
        return prescriptionDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(PrescriptionDetail record) {
        return prescriptionDetailMapper.insertSelective(record);
    }

    @Override
    public PrescriptionDetail selectByPrimaryKey(Long id) {
        return prescriptionDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PrescriptionDetail record) {
        return prescriptionDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PrescriptionDetail record) {
        return prescriptionDetailMapper.updateByPrimaryKey(record);
    }

}
