package cn.test.service.impl;

import cn.test.mapper.ScheduleMapper;
import cn.test.pojo.Schedule;
import cn.test.service.ScheduleService;
import cn.test.util.result.Result;
import cn.test.util.result.ResultEnum;
import cn.test.util.result.ResultUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Resource
    private ScheduleMapper scheduleMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return scheduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Schedule record) {
        return scheduleMapper.insert(record);
    }

    @Override
    public int insertSelective(Schedule record) {
        return scheduleMapper.insertSelective(record);
    }

    @Override
    public Schedule selectByPrimaryKey(Long id) {
        return scheduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Schedule record) {
        return scheduleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Schedule record) {
        return scheduleMapper.updateByPrimaryKey(record);
    }

    @Override
    public Result getDoctorList(Schedule schedule) {
        List<Schedule> doctorList = scheduleMapper.getDoctorList(schedule);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date =simpleDateFormat.format(new Date());
        for (int i = 0; i < doctorList.size(); i++) {
            //转换时间格式
            String docDate = simpleDateFormat.format(doctorList.get(i).getInquiryTime());
            //判断时间是否相等
            if(doctorList.get(i).getRemainingQuantity() < 1 || !date.equals(docDate)){
                doctorList.remove(i);
                i--;

            }

        }

        if(doctorList.isEmpty() ||doctorList.size()==0){

            return ResultUtils.returnResult(ResultEnum.SCHEDULE_DOCTOR_EMPTY);
        }
        return ResultUtils.returnDataSuccess(doctorList);
    }

}
