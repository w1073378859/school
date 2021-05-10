package cn.test.exception;

/**
 * @author ct.team
 * @Description 此异常类型用来向前台返回页面
 * Version 1.0
 */
public class ReturnViewException  extends Exception {

    private static final long serialVersionUID = -1668707977736987938L;

    /** 异常信息 */
    public String message;

    public ReturnViewException (String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
