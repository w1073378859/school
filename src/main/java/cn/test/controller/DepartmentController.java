package cn.test.controller;

import cn.test.service.DepartmentService;
import cn.test.util.result.Result;
import cn.test.util.result.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Package: cn.test.controller
 * @Description: 就诊科室
 * @Author Wh
 * @Create 2021年03月29日 10时59分36秒
 */
@Controller
@RequestMapping("/api/department")
public class DepartmentController {

    @Resource
    DepartmentService departmentService;

    @RequestMapping("getDepartmentList.json")
    @ResponseBody
    public Result getDepartmentList(){

        return ResultUtils.returnDataSuccess(departmentService.getDepartmentList());
    }
}
