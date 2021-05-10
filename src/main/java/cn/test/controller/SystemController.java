package cn.test.controller;

import cn.test.pojo.SysUsers;
import cn.test.service.SysUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: cn.test.controller
 * @Description:
 * @Author JC
 * @Create 2021年03月22日 10时11分34秒
 */
@RestController
@RequestMapping("user")
public class SystemController {

    @Autowired
    SysUsersService sysUsersService;

    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    public SysUsers queryByUsernameAndPassword(SysUsers sysUsers){

        SysUsers sysUsers1 = sysUsersService.queryByUsernameAndPassword(sysUsers);
        return sysUsers1;
    }


}
