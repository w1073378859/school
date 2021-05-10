package cn.test.mapper;

import cn.test.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**  
* @Package: mapper
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Mapper
public interface DepartmentMapper {
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
    int insert(Department record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Department record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Department selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Department record);

    /**
     * @Author: W
     * @Date: 2021年03月88日 11时03分50秒
     * @Description: 查询所有就诊科室

     * @return java.util.List<cn.test.pojo.Department>
     **/
    List<Department> getDepartmentList();
}