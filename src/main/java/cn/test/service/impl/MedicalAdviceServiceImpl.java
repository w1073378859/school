package cn.test.service.impl;

import cn.test.mapper.MedicalAdviceMapper;
import cn.test.pojo.MedicalAdvice;
import cn.test.service.MedicalAdviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class MedicalAdviceServiceImpl implements MedicalAdviceService{

    @Resource
    private MedicalAdviceMapper medicalAdviceMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return medicalAdviceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MedicalAdvice record) {
        return medicalAdviceMapper.insert(record);
    }

    @Override
    public boolean insertSelective(MedicalAdvice record) throws Exception {
        MedicalAdvice medicalAdvices = medicalAdviceById(record.getRegistryId());
        medicalAdviceById(record.getRegistryId());

        if(medicalAdvices!=null){

            Long id = (Long) medicalAdvices.getId();
            record.setId(id);
            record.setUpdatedTime(new Date());
            record.setCreatedTime(null);
            System.out.println("执行修改sql语句");
            return medicalAdviceMapper.updateByPrimaryKeySelective(record)>0?true:false;
        }
        System.out.println("执行新增sql语句");
        return medicalAdviceMapper.insertSelective(record) >0 ? true:false;
    }

    @Override
    public MedicalAdvice selectByPrimaryKey(Long id) {
        return medicalAdviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MedicalAdvice record) {
        return medicalAdviceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MedicalAdvice record) {
        return medicalAdviceMapper.updateByPrimaryKey(record);
    }

    @Override
    public MedicalAdvice medicalAdviceById(Long rId) {
        return medicalAdviceMapper.medicalAdviceById(rId);
    }

}
