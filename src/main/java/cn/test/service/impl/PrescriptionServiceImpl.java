package cn.test.service.impl;

import cn.test.mapper.PrescriptionMapper;
import cn.test.pojo.Prescription;
import cn.test.service.PrescriptionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class PrescriptionServiceImpl implements PrescriptionService{

    @Resource
    private PrescriptionMapper prescriptionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return prescriptionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Prescription record) {
        return prescriptionMapper.insert(record);
    }

    @Override
    public int insertSelective(Prescription record) {
        return prescriptionMapper.insertSelective(record);
    }

    @Override
    public Prescription selectByPrimaryKey(Long id) {
        return prescriptionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Prescription record) {
        return prescriptionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Prescription record) {
        return prescriptionMapper.updateByPrimaryKey(record);
    }

}
