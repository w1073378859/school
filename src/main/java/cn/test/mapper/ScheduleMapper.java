package cn.test.mapper;

import cn.test.pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**  
* @Package: mapper
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Mapper
public interface ScheduleMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Schedule record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Schedule record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Schedule selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Schedule record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Schedule record);

    /**
     * @Author: W
     * @Date: 2021年03月88日 11时03分22秒
     * @Description: 查询医生列表
     * @param schedule
     * @return java.util.List<cn.test.pojo.Schedule>
     **/
    List<Schedule> getDoctorList(Schedule schedule);
}