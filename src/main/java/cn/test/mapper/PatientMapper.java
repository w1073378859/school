package cn.test.mapper;

import cn.test.pojo.Patient;
import org.apache.ibatis.annotations.Mapper;

/**  
* @Package: mapper
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Mapper
public interface PatientMapper {
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
    int insert(Patient record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Patient record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Patient selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Patient record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Patient record);

    /**
     * @Author: W
     * @Date: 2021年03月85日 16时03分14秒
     * @Description: 根据医保卡查询就诊卡
     * @param idMedicare
     * @return cn.test.pojo.Patient
     **/
    Patient getPatientByIdmed(String idMedicare);

    /**
     * @Author: W
     * @Date: 2021年03月85日 16时03分56秒
     * @Description: 根据身份证号查询就诊卡
     * @param idCard
     * @return cn.test.pojo.Patient
     **/
    Patient getPatientByIdCard(String idCard);
}