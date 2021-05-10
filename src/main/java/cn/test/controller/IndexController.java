package cn.test.controller;

import cn.test.pojo.SysUsers;
import cn.test.service.SysUsersService;
import cn.test.util.util.Constants;
import cn.test.util.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Package: cn.test.controller
 * @Description:
 * @Author JC
 * @Create 2021年03月22日 16时40分39秒
 */
@Controller
public class IndexController {
    @Autowired
    SysUsersService sysUsersService;


    @RequestMapping("index")
    public String index(){

        return "login";
    }

    @RequestMapping("login")
    public String login(){

        return "login";
    }


    /**
     * @Author: W
     * @Date: 2021年03月82日 11时03分28秒
     * @Description: 登录
     * @param sysUsers
     * @param session
     * @param request
     * @return java.lang.String
     **/
    @RequestMapping("doLogin")
    public String doLogin(SysUsers sysUsers, HttpSession session, HttpServletRequest request){
        SysUsers sysUsers1 = sysUsersService.getUserByAccount(sysUsers.getAccount());
        //判断账号是否存在
        if(sysUsers1==null) {
            request.setAttribute("error", "用户名不存在！");
            return "/login";
        }
        boolean flag = PasswordUtil.match(sysUsers.getPassword(),(sysUsers1.getPassword()).toUpperCase());
        //判断密码是否错误
        if(!flag){
            request.setAttribute("error", "密码错误！");
            return "/login";
        }else {
            System.out.println("登录成功");
            sysUsers1.setPassword("");
            session.setAttribute(Constants.USER_SESSION, sysUsers1);
            return "redirect:/api/users/index";
        }
    }

    @RequestMapping("/api/users/index")
    public String main(){

        return "main";
    }

    @RequestMapping("/403")
    public String err(){
        return "403";
    }

    @RequestMapping("/500")
    public String exce(){
        return "500";
    }
}
