package cn.test.service;

import cn.test.pojo.Department;

import java.util.List;

/**
* @Package: impl
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
public interface DepartmentService{


int deleteByPrimaryKey(Long id);

int insert(Department record);

int insertSelective(Department record);

Department selectByPrimaryKey(Long id);

int updateByPrimaryKeySelective(Department record);

int updateByPrimaryKey(Department record);

    /**
     * @Author: W
     * @Date: 2021年03月88日 11时03分43秒
     * @Description: 查询就诊科室

     * @return java.util.List<cn.test.pojo.Department>
     **/
    List<Department> getDepartmentList();

}
