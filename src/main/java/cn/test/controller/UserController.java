package cn.test.controller;

import cn.test.pojo.SysUsers;
import cn.test.service.SysUsersService;
import cn.test.util.result.Result;
import cn.test.util.result.ResultEnum;
import cn.test.util.result.ResultUtils;
import cn.test.util.util.Constants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

/**
 * @Package: cn.test.controller
 * @Description:
 * @Author Wh
 * @Create 2021年03月24日 13时53分39秒
 */
@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    SysUsersService sysUsersService;

    /**
     * @Author: W
     * @Date: 2021年03月84日 08时03分11秒
     * @Description: 分页的页码
     * @param pageNum
     * @param model
     * @return java.lang.String
     **/
    @RequestMapping("/list")
    public String getUser(@RequestParam(value = "pageNum",defaultValue = "1",required = false)Integer pageNum, Model model){

        PageHelper.startPage(pageNum,4);
        List<SysUsers> usersList = sysUsersService.getUsersList(null);
        PageInfo<SysUsers> info = new PageInfo<>(usersList);
        model.addAttribute("pages",info);
        return "userList";
    }

    /**
     * @Author: W 
     * @Date: 2021年03月84日 11时03分52秒
     * @Description: 回显图形
     * @param userId
     * @param request
     * @param response
     * @return void
     **/
    @RequestMapping("showImg")
    public void showImg(@RequestParam(value = "userId") Integer userId, HttpServletRequest request , HttpServletResponse response) throws IOException {
        //查询用户头像
        String userUrl = sysUsersService.getUserUrl(userId);
        InputStream inputStream = null;
        //用户是否设置头像，如果没有显示默认头像
        if(StringUtil.isEmpty(userUrl)){
            ClassPathResource classPathResource = new ClassPathResource(Constants.FILE_DEFAULT_HEAD_PATH);
            inputStream = classPathResource.getInputStream();
        }else {
            inputStream = new FileInputStream(userUrl);
        }
        int available = inputStream.available();
        byte[] bytes = new byte[available];
        inputStream.read(bytes);
        response.setContentType("image/*");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    /**
     * @Author: W
     * @Date: 2021年03月85日 14时03分58秒
     * @Description: 添加用户页面

     * @return java.lang.String
     **/
    @RequestMapping("/addUser")
    public String userAdd(){

        return "userAdd";
    }

    /**
     * @Author: W
     * @Date: 2021年03月85日 14时03分46秒
     * @Description: 添加用户
     * @param sysUsers
     * @return java.lang.String
     **/
    @PostMapping("/addUserSave")
    public String addUser(@ModelAttribute SysUsers sysUsers, HttpServletRequest request, @RequestParam(value = "userImg") MultipartFile file){
        //添加用户
            sysUsers.setCreatedTime(new Date());
            sysUsers.setUpdatedTime(new Date());
            Result result = sysUsersService.insert(sysUsers,file);
            System.out.println(result.toString());
            if(result.code.equals(ResultEnum.SUCCESS.getCode())){
                return "redirect:/api/users/list";
            }
            request.setAttribute("fileUploadError",result.msg);
            return "userAdd";

    }

    /**
     * @Author: W
     * @Date: 2021年03月85日 16时03分57秒
     * @Description: 判断用户是否存在
     * @param account
     * @return cn.test.util.result.Result
     **/
    @ResponseBody
    @RequestMapping("/accountExist.json")
    public Result accountExist(String account){

        SysUsers userByAccount = sysUsersService.getUserByAccount(account);
        if(userByAccount==null){
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnFail();
    }


    /**
     * @Author: W
     * @Date: 2021年04月104日 09时04分28秒
     * @Description: 按科室返回医生列表
     * @param departmentId
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @ResponseBody
    @RequestMapping("/getDoctorList.json")
    public Result getDoctorList(@RequestParam(value = "departmentId",required = false,defaultValue = "0") Integer departmentId){
        SysUsers sysUsers = new SysUsers();
        sysUsers.setDepartmentId(Long.valueOf(departmentId));
        sysUsers.setUserType(3);
        return ResultUtils.returnDataSuccess(sysUsersService.getDoctorList(sysUsers));
    }

}
