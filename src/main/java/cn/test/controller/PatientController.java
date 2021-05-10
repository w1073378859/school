package cn.test.controller;

import cn.test.pojo.Patient;
import cn.test.service.PatientService;
import cn.test.util.result.Result;
import cn.test.util.result.ResultEnum;
import cn.test.util.result.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Package: cn.test.controller
 * @Description:
 * @Author Wh
 * @Create 2021年03月26日 16时33分44秒
 */
@Controller
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    /**
     * @Author: W
     * @Date: 2021年03月85日 16时03分03秒
     * @Description: 创建就诊卡页面

     * @return java.lang.String
     **/
    @RequestMapping("/patientAdd")
    public String patientAdd(){

        return "patientAdd";
    }

    /**
     * @Author: W
     * @Date: 2021年03月85日 18时03分05秒
     * @Description: 创建就诊卡
     * @param patient
     * @param request
     * @return java.lang.String
     **/
    @RequestMapping("createVisitCard")
    public String createVisitCard(Patient patient, HttpServletRequest request){
            if(patient.equals(null)||patient==null){
                return "patientAdd";
            }
            patient.setCreatedTime(new Date());
            Result result = patientService.insertPatient(patient);
            if(result.code.equals(ResultEnum.SUCCESS.getCode())){
                return "redirect:/api/users/index";
            }
            System.out.println("创建失败");

       return  "patientAdd";
    }

    /**
     * @Author: W
     * @Date: 2021年03月85日 16时03分01秒
     * @Description: 判断医保卡重复
     * @param idMedicare
     * @return cn.test.util.result.Result
     **/
    @ResponseBody
    @RequestMapping("getPatientByIdMedicare.json")
    public Result getPatientByIdMedicare(String idMedicare){
        if(!idMedicare.equals("")) {
            Patient patientByIdmed = patientService.getPatientByIdmed(idMedicare);

            if (patientByIdmed == null) {
                return ResultUtils.returnFail();
            }
            return ResultUtils.returnDataSuccess(patientByIdmed);
        }
        return ResultUtils.returnFail();
    }

   /**
    * @Author: W
    * @Date: 2021年04月103日 09时04分36秒
    * @Description: 身份证判断
    * @param idCard
    * @return cn.test.util.result.Result
    **/
    @ResponseBody
    @RequestMapping(value = "getPatientByIdCard.json",method = RequestMethod.POST)
    public Result getPatientByIdCard(@RequestParam("idCard") String idCard){
        if(idCard.isEmpty()){
            return ResultUtils.returnResult(ResultEnum.PATIENT_ID_CARD_EMPTY);
        }
        Patient patientByIdCard = patientService.getPatientByIdCard(idCard);
        if(patientByIdCard == null){
            return ResultUtils.returnFail();
        }
        return ResultUtils.returnDataSuccess(patientByIdCard);
    }

}
