package cn.test.service.impl;

import cn.test.mapper.SysRolesMenusMapper;
import cn.test.pojo.SysRolesMenus;
import cn.test.service.SysRolesMenusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class SysRolesMenusServiceImpl implements SysRolesMenusService{

    @Resource
    private SysRolesMenusMapper sysRolesMenusMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysRolesMenusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysRolesMenus record) {
        return sysRolesMenusMapper.insert(record);
    }

    @Override
    public int insertSelective(SysRolesMenus record) {
        return sysRolesMenusMapper.insertSelective(record);
    }

    @Override
    public SysRolesMenus selectByPrimaryKey(Long id) {
        return sysRolesMenusMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRolesMenus record) {
        return sysRolesMenusMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRolesMenus record) {
        return sysRolesMenusMapper.updateByPrimaryKey(record);
    }

}
