package cn.test.service.impl;

import cn.test.mapper.PatientMapper;
import cn.test.pojo.Patient;
import cn.test.service.PatientService;
import cn.test.util.result.Result;
import cn.test.util.result.ResultEnum;
import cn.test.util.result.ResultUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class PatientServiceImpl implements PatientService{

    @Resource
    private PatientMapper patientMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return patientMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Result insertPatient(Patient record) {
        int num = patientMapper.insertSelective(record);
        if (num == 0){
            return ResultUtils.returnResult(ResultEnum.PATIENT_NULL);
        }
        return ResultUtils.returnSuccess();
    }

    @Override
    public int insertSelective(Patient record) {
        return patientMapper.insertSelective(record);
    }

    @Override
    public Patient selectByPrimaryKey(Long id) {
        return patientMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Patient record) {
        return patientMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Patient record) {
        return patientMapper.updateByPrimaryKey(record);
    }

    @Override
    public Patient getPatientByIdmed(String idMedicare) {
        return patientMapper.getPatientByIdmed(idMedicare);
    }

    @Override
    public Patient getPatientByIdCard(String idCard) {
        return patientMapper.getPatientByIdCard(idCard);
    }

}
