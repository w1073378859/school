package cn.test.util;

/**
 * @Package: cn.ct.utils
 * @Description:
 * @Author JC
 * @Create 2021年03月22日 09时23分01秒
 */
public class ResultMsg {

    /**
     * @Author: W
     * @Date: 2021年03月81日 09时03分18秒
     * @Description: 成功返回信息
     * @return cn.ct.utils.Msg
     **/
    private Msg success(Object data){
        return new Msg("200","success",data);
    }

    /**
     * @Author: W
     * @Date: 2021年03月81日 10时03分18秒
     * @Description: 失败返回信息
     * @return cn.ct.utils.Msg
     **/
    public static Msg error(Object data){
        return new Msg("500","error",data);
    }
}
