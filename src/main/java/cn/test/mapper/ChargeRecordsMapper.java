package cn.test.mapper;

import cn.test.pojo.ChargeRecords;
import org.apache.ibatis.annotations.Mapper;

/**  
* @Package: mapper
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Mapper
public interface ChargeRecordsMapper {
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
    int insert(ChargeRecords record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ChargeRecords record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ChargeRecords selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ChargeRecords record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ChargeRecords record);
}