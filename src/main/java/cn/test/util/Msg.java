package cn.test.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package: cn.ct.utils
 * @Description:
 * @Author JC
 * @Create 2021年03月22日 09时20分19秒
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg<T> {

    private String code;
    private String msg;
    private T date;

    public Msg(String code,String msg){
        this.code = code;
        this.msg = msg;
        date = null;
    }
}
