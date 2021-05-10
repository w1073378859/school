package cn.test.controller;

import cn.test.pojo.MedicalAdvice;
import cn.test.pojo.Registry;
import cn.test.service.RegistryService;
import cn.test.service.MedicalAdviceService;
import cn.test.util.result.Result;
import cn.test.util.result.ResultEnum;
import cn.test.util.result.ResultUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: cn.test.controller
 * @Description: 挂号
 * @Author Wh
 * @Create 2021年03月29日 10时38分02秒
 */
@Controller
@RequestMapping("/api/register")
public class RegisterController {

    @Resource
    RegistryService registryService;

    @Autowired
    MedicalAdviceService medicalAdviceService;

    @RequestMapping("/registerAdd")
    public String registerAdd(){

        return "registerAdd";
    }

    /**
     * @Author: W
     * @Date: 2021年04月98日 09时04分21秒
     * @Description: 创建医保免费
     * @param sign
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    @ResponseBody
    @RequestMapping(value = "createFee.json",method = RequestMethod.POST)
    public Result createFee(@RequestParam(value = "sign",required = false,defaultValue = "null") String sign){
        HashMap<String,Object> map = new HashMap<>();
        Integer fee = null;
        Integer medicareFee = null;
        Integer payFee = null;
        if(sign.equals("medicare") || sign == "medicare") {

            fee = 50;
            medicareFee = 40;
            payFee = 10;
        }else {
            fee = 50;
            medicareFee = 0;
            payFee = 50;
        }
        map.put("fee",fee);
        map.put("medicareFee",medicareFee);
        map.put("payFee",payFee);
        return ResultUtils.returnDataSuccess(map);
    }

    /**
     * @Author: W 
     * @Date: 2021年04月98日 10时04分05秒
     * @Description: 添加挂号
     * @param registry
     * @return java.lang.String
     **/
    @RequestMapping("/registerSave")
    public String register(Registry registry){
        registry.setConsultationTime(new Date());
        registry.setRegistryTime(new Date());
        registry.setCreatedTime(new Date());
        Result result = registryService.insertSelective(registry);
        if(result.code.equals(ResultEnum.SUCCESS.getCode())){
            return "redirect:/api/users/index";
        }
        return "";
    }

    /**
     * @Author: W
     * @Date: 2021年04月111日 10时04分05秒
     * @Description: 挂号页面

     * @return java.lang.String
     **/
    @RequestMapping(value = "registerList")
    public String registerList(){
        return "registerList";
    }

    /**
     * @Author: W 
     * @Date: 2021年04月98日 11时04分26秒
     * @Description: 读取挂号列表
     * @param pageNum
     * @param model
     * @return java.lang.String
     **/
    @ResponseBody
    @GetMapping(value = "getRegisterList.json")
    public PageInfo<Map<String, Object>> getRegisterList(@RequestParam(value = "pageNum",defaultValue = "1",required = false) Integer pageNum,
                                                         @RequestParam(value = "idCard",required = false) String idCard,
                                                         @RequestParam(value = "departmentId",required = false,defaultValue = "0") Integer departmentId,
                                                         @RequestParam(value = "userId",required = false,defaultValue = "0") Integer userId,
                                                         @RequestParam(value = "status",required = false,defaultValue = "0") Integer status, Model model){

        PageHelper.startPage(pageNum,5);
        List<Map<String, Object>> maps = registryService.registryList(idCard,Long.valueOf(departmentId),Long.valueOf(userId),status);
        PageInfo<Map<String, Object>> info = new PageInfo<>(maps);
        return info;
    }


    /**
     * @Author: W
     * @Date: 2021年04月98日 14时04分37秒
     * @Description: 获取挂号详细信息
     * @param id
     * @param model
     * @return java.lang.String
     **/
    @RequestMapping("registerView/{id}")
    public String registerView(@PathVariable("id")Integer id, Model model){
        Map<String, Object> register = registryService.registryListById(Long.valueOf(id));
        MedicalAdvice medicalAdvice = medicalAdviceService.medicalAdviceById(Long.valueOf(id));
        model.addAttribute("register",register);
        model.addAttribute("medicalAdvice",medicalAdvice);
        return "registerView";
    }

    /**
     * @Author: W 
     * @Date: 2021年04月113日 17时04分58秒
     * @Description: 就诊信息
    
     * @return java.lang.String
     **/
    @RequestMapping("registerInfoList")
    public String registerInfoList(){

        return "registerInfoList";
    }


}
