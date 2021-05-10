package cn.test.service.impl;

import cn.test.mapper.SysUsersMapper;
import cn.test.pojo.SysUsers;
import cn.test.service.SysUsersService;
import cn.test.util.MD5;
import cn.test.util.result.Result;
import cn.test.util.result.ResultEnum;
import cn.test.util.result.ResultUtils;
import cn.test.util.util.Constants;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

/**
* @Package: service
* @Description: ${description}
* @Author JC
* @Create 2021年03月19日 16时33分46秒
*/
@Service
public class SysUsersServiceImpl implements SysUsersService{

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Value("${windowsFilePath}")
    private String windowsPath;
    @Value("${linuxFilePath}")
    private String linuxPath;


    @Override
    public Result insert(SysUsers record, MultipartFile file) {
        //判断是否有图片
        if(file == null || file.isEmpty()){
            return ResultUtils.returnResult(ResultEnum.FAIL_FILE_EMPTY);
        }
        //图片大小过大
        if(file.getSize() > Constants.FILE_SIZE){
            return ResultUtils.returnResult(ResultEnum.FAIL_FILE_SIZE_ERROR);
        }
        //原文件
        String fileName = file.getOriginalFilename();
        String preName = FilenameUtils.getExtension(fileName);
        //判断图片类型
        if(!(Constants.FILE_JEPG.equals(preName)
                || Constants.FILE_JPG.equals(preName)
                || Constants.FILE_PNEG.equals(preName)
                || Constants.FILE_JPEG.equals(preName)
                || Constants.FILE_PNG.equals(preName)
        )){
            return  ResultUtils.returnResult(ResultEnum.FAIL_FILE_SUFFIX_ERROR);
        }
        //文件路径
        String property = System.getProperty("os.name");
        String filePath = property.toLowerCase().startsWith("win") ? windowsPath : linuxPath;
        String name = filePath + System.currentTimeMillis() + "-" + fileName;

        //文件上传
        uploadFile(filePath,name,file);
        record.setHeadUrl(name);
        //获取密码
        String pwd = record.getPassword();
        //密码加密
        String md5 = MD5.getMd5(pwd,32);
        record.setPassword(md5);

            Integer num = sysUsersMapper.insert(record);
        if (num == 0){
            return ResultUtils.returnResult(ResultEnum.FAIL_USER_ADD_ERROR);
        }
        return ResultUtils.returnSuccess();
    }


    @Override
    public SysUsers queryByUsernameAndPassword(SysUsers sysUsers) {
        String password = sysUsers.getPassword();
        String md5 = MD5.getMd5(password,32);
        sysUsers.setPassword(md5.toUpperCase());
        SysUsers sysUsers1 = sysUsersMapper.queryByUsernameAndPassword(sysUsers);
        sysUsers1.setSalt(null);
        sysUsers1.setPassword(null);
        return sysUsers1;
    }

    @Override
    public SysUsers getUserByAccount(String account) {

        return sysUsersMapper.getUserByAccount(account);
    }

    @Override
    public List<SysUsers> getUsersList(SysUsers sysUserReq) {
        return sysUsersMapper.getUsersList(sysUserReq);
    }

    @Override
    public String getUserUrl(Integer userId) {
        return sysUsersMapper.getUserUrl(userId);
    }

    @Override
    public SysUsers getUserById(Long id) {
        return sysUsersMapper.getUserById(id);
    }

    @Override
    public void uploadFile(String filePath, String fileName, MultipartFile file) {

        BufferedOutputStream outputStream = null;
        try {
            //获取文件路径
            File file1 = new File(filePath);
            //判断文件名称
            if (!file1.exists()) {
                file1.mkdir();
            }
            outputStream = new BufferedOutputStream(new FileOutputStream(fileName));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public List<Map<String, Object>> getDoctorList(SysUsers sysUsers) {
        return sysUsersMapper.getDoctorList(sysUsers);
    }
}
