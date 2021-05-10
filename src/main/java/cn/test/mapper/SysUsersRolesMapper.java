package cn.test.mapper;

import cn.test.pojo.SysUsersRoles;
import org.apache.ibatis.annotations.Mapper;

/**  
* @Package: mapper
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Mapper
public interface SysUsersRolesMapper {
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
    int insert(SysUsersRoles record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysUsersRoles record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    SysUsersRoles selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysUsersRoles record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SysUsersRoles record);
}