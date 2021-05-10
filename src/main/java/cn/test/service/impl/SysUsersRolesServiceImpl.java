package cn.test.service.impl;

import cn.test.mapper.SysUsersRolesMapper;
import cn.test.pojo.SysUsersRoles;
import cn.test.service.SysUsersRolesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class SysUsersRolesServiceImpl implements SysUsersRolesService{

    @Resource
    private SysUsersRolesMapper sysUsersRolesMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUsersRolesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUsersRoles record) {
        return sysUsersRolesMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUsersRoles record) {
        return sysUsersRolesMapper.insertSelective(record);
    }

    @Override
    public SysUsersRoles selectByPrimaryKey(Long id) {
        return sysUsersRolesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUsersRoles record) {
        return sysUsersRolesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUsersRoles record) {
        return sysUsersRolesMapper.updateByPrimaryKey(record);
    }

}
