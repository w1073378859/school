package cn.test.mapper;

import cn.test.pojo.MedicalAdvice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Package: mapper
 * @Description: ${description}
 * @Author JC
 * @Create 2021年03月19日 16时33分46秒
 */
@Mapper
public interface MedicalAdviceMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(MedicalAdvice record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(MedicalAdvice record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    MedicalAdvice selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MedicalAdvice record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MedicalAdvice record);

    /**
     * @param rId
     * @return cn.test.pojo.MedicalAdvice
     * @Author: W
     * @Date: 2021年04月98日 14时04分00秒
     * @Description: 按挂号查询医嘱
     **/
    MedicalAdvice medicalAdviceById(@Param("rId") Long rId);
}