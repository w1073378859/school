package cn.test.controller;

import cn.test.pojo.Schedule;
import cn.test.service.ScheduleService;
import cn.test.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package: cn.test.controller
 * @Description:
 * @Author Wh
 * @Create 2021年03月29日 11时24分54秒
 */
@Controller
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @ResponseBody
    @RequestMapping("getDoctorList.json")
    public Result getDoctorList(Schedule schedule){

        return scheduleService.getDoctorList(schedule);
    }
}
