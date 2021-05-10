package cn.test.service;

import cn.test.pojo.Schedule;
import cn.test.util.result.Result;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface ScheduleService{


int deleteByPrimaryKey(Long id);

int insert(Schedule record);

int insertSelective(Schedule record);

Schedule selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(Schedule record);

int updateByPrimaryKey(Schedule record);

    /**
     * @Author: W
     * @Date: 2021年03月88日 11时03分52秒
     * @Description: 查询医生列表
     * @param schedule
     * @return java.util.List<cn.test.pojo.Schedule>
     **/
    Result getDoctorList(Schedule schedule);

}
