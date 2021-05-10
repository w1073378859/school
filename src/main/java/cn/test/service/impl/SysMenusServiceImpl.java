package cn.test.service.impl;

import cn.test.mapper.SysMenusMapper;
import cn.test.mapper.SysUsersMapper;
import cn.test.pojo.SysMenus;
import cn.test.pojo.SysUsers;
import cn.test.service.SysMenusService;
import cn.test.util.result.Result;
import cn.test.util.result.ResultEnum;
import cn.test.util.result.ResultUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class SysMenusServiceImpl implements SysMenusService{

    @Resource
    private SysMenusMapper sysMenusMapper;
    @Resource
    private SysUsersMapper sysUsersMapper;


    @Override
    public Result<List<SysMenus>> getMenusList(Integer userId) {
        SysUsers sysUsers = sysUsersMapper.getUserById(Long.valueOf(userId));
        if(sysUsers==null){
            return ResultUtils.returnResult(ResultEnum.FAIL_USER_GET);
        }
        List<SysMenus> menusList = sysMenusMapper.getMenusList(sysUsers.getUserType());

        return ResultUtils.returnDataSuccess(menusList);
    }
}
