package cn.test.controller;

import cn.test.pojo.SysMenus;
import cn.test.pojo.SysRoles;
import cn.test.service.SysMenusService;
import cn.test.service.SysRolesService;
import cn.test.util.result.Result;
import cn.test.util.result.ResultUtils;
import cn.test.util.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Package: cn.test.controller
 * @Description:
 * @Author Wh
 * @Create 2021年03月25日 13时50分31秒
 */
@Controller
@RequestMapping("/api/auth")
public class AuthController {

    @Resource
    SysMenusService sysMenusService;
    @Resource
    SysRolesService sysRolesService;

    /**
     * @Author: W
     * @Date: 2021年04月98日 11时04分55秒
     * @Description: 获取菜单
     * @param userId
     * @return cn.test.util.result.Result<java.util.List<cn.test.pojo.SysMenus>>
     **/
    @ResponseBody
    @RequestMapping("getMenuList.json")
    public Result<List<SysMenus>> getMenuList(Integer userId){

        return  sysMenusService.getMenusList(userId);
    }

    /**
     * @Author: W
     * @Date: 2021年04月98日 11时04分27秒
     * @Description: 获取角色

     * @return cn.test.util.result.Result<java.util.List<cn.test.pojo.SysRoles>>
     **/
    @ResponseBody
    @RequestMapping("getRoleList.json")
    public Result<List<SysRoles>> getRoleList(){

        return ResultUtils.returnDataSuccess(sysRolesService.getRoleList());
    }

    /**
     * @Author: W
     * @Date: 2021年04月97日 08时04分21秒
     * @Description: 退出
     * @param session
     * @return java.lang.String
     **/
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute(Constants.USER_SESSION);

        return "redirect:/login";
    }
}
