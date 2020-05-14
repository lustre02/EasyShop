package com.lustre.mall.core.state;

public class ResponseState {


    private ResponseState() {

    }

    /**
     * 请求成功
     */
    public final static int OK = 20000;
    /**
     * 非法访问
     */
    public final static int ILLEGAL_CALL = 10001;
    /**
     * 校验不通过
     */
    public final static int VALID_FAIL = 10002;
    /**
     * 未知异常
     */
    public final static int UNKNOWN_EXCEPTION = 14444;

    /**
     * 上传失败
     */
    public final static int UPLOAD_FAILED = 10003;

    /**
     * 用户名或密码错误
     */
    public final static int WRONG_LOGIN = 10004;

    /**
     * 添加失败
     */
    public final static int INSERT_FAILED = 10005;

    /**
     * 删除失败
     */
    public final static int DELETE_FAILED = 10006;

    /**
     * 用户不存在
     */
    public final static int USER_NOTFOUND = 10007;

    /**
     * 注册失败
     */
    public final static int REGISTER_FAILED = 10008;

}
