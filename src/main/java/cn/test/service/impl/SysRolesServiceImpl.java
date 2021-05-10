package cn.test.service.impl;

import cn.test.mapper.SysRolesMapper;
import cn.test.pojo.SysRoles;
import cn.test.service.SysRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class SysRolesServiceImpl implements SysRolesService{

    @Autowired
    SysRolesMapper sysRolesMapper;

    @Override
    public List<SysRoles> getRoleList() {
        return sysRolesMapper.getRoleList();
    }

}
