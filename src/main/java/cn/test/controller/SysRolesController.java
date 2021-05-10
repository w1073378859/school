package cn.test.controller;

import cn.test.service.SysRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: cn.test.controller
 * @Description:
 * @Author Wh
 * @Create 2021年03月25日 10时58分14秒
 */
@RestController
public class SysRolesController {

    @Autowired
    SysRolesService sysRolesService;


}
