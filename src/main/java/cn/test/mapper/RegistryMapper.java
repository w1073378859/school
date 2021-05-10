package cn.test.mapper;

import cn.test.pojo.Registry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**  
* @Package: mapper
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Mapper
public interface RegistryMapper {
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
    int insert(Registry record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Registry record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Registry selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Registry record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Registry record);
    
    /**
     * @Author: W 
     * @Date: 2021年04月98日 10时04分09秒
     * @Description: 获取挂号列表
    
     * @return java.util.List<Map<String,Object>>
     **/
    List<Map<String,Object>> registryList(@Param("idCard") String idCard, @Param("departmentId") Long departmentId, @Param("userId") Long userId, @Param("status") Integer status);

    /**
     * @Author: W
     * @Date: 2021年04月98日 14时04分36秒
     * @Description: 获取挂号的详细信息
     * @param id
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String,Object> registryListById(Long id);
}