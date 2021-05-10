package cn.test.controller;

import cn.test.pojo.MedicalAdvice;
import cn.test.pojo.Registry;
import cn.test.service.MedicalAdviceService;
import cn.test.service.RegistryService;
import cn.test.util.result.Result;
import cn.test.util.result.ResultEnum;
import cn.test.util.result.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Package: cn.test.controller
 * @Description: 医嘱
 * @Author Wh
 * @Create 2021年04月25日 08时46分10秒
 */
@Controller
@RequestMapping("/api/consultation")
public class ConsultationController {

    @Resource
    RegistryService registryService;

    @Resource
    MedicalAdviceService medicalAdviceService;

    /**
     * @Author: W
     * @Date: 2021年04月115日 14时04分13秒
     * @Description: 开始问诊
     * @param id
     * @param model
     * @return java.lang.String
     **/
    @RequestMapping("consultationAdd")
    public String consultationAdd(Integer id, Model model){
        //查询病人信息
        Map<String, Object> stringObjectMap = registryService.registryListById(Long.valueOf(id));
        model.addAttribute("register",stringObjectMap);
        //查询医嘱信息
        MedicalAdvice medicalAdvice = medicalAdviceService.medicalAdviceById(Long.valueOf(id));
        model.addAttribute("medicalAdvice",medicalAdvice);
        return "consultationAdd";
    }

    /**
     * @Author: W 
     * @Date: 2021年04月116日 11时04分49秒
     * @Description: 获取医嘱
     * @param id
     * @return cn.test.pojo.MedicalAdvice
     **/
    @ResponseBody
    @RequestMapping("medicalAdvice.json")
    public MedicalAdvice medicalAdvice(Integer id){

        return medicalAdviceService.medicalAdviceById(Long.valueOf(id));
    }

    /**
     * @Author: W
     * @Date: 2021年04月115日 14时04分55秒
     * @Description: 添加医嘱
     * @param medicalAdvice
     * @return cn.test.util.result.Result
     **/
    @ResponseBody
    @RequestMapping(value = "medicalAdviceAdd.json",method = RequestMethod.POST)
    public Result medicalAdviceAdd(MedicalAdvice medicalAdvice) throws Exception {
        medicalAdvice.setCreatedTime(new Date());
        //添加医嘱
        //System.out.println(medicalAdvice.toString());
        boolean b = medicalAdviceService.insertSelective(medicalAdvice);
        if(b){
            MedicalAdvice medicalAdvice1 = medicalAdviceService.selectByPrimaryKey(medicalAdvice.getId());
            return ResultUtils.returnDataSuccess(medicalAdvice1);
        }
       return ResultUtils.returnResult(ResultEnum.FAIL_ADD_MEDICAL_ADVICE);
    }

    /**
     * @Author: W
     * @Date: 2021年04月115日 14时04分23秒
     * @Description: 结束问诊
     * @param registryId
     * @return java.lang.String
     **/
    @RequestMapping(value = "consultationEnd",method = RequestMethod.POST)
    public String consultationEnd(Integer registryId){
        Registry registry = registryService.selectByPrimaryKey(Long.valueOf(registryId));
        registry.setConsultationTime(new Date());
        registry.setStatus((byte) 3);
        registry.setConsultationTime(new Date());
        if(registryService.updateByPrimaryKeySelective(registry)){
            return "redirect:/api/register/registerInfoList";
        }
        return "consultationAdd";
    }
}
