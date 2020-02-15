package learn.lhb.my.shop.commons.dto;

import java.io.Serializable;

/**
 * 数据传输对象的结果封装
 * 自定义返回结果集
 *
 * @author 梁鸿斌
 * @date 2020/2/15.
 * @time 17:45
 */
// TODO 这个放到笔记里，以后可能还有进一步优化k,顺便参考长俊的
public class BaseResult implements Serializable {

    // 常量
    public static final int STATUS_OK = 200; // 请求成功的状态码
    public static final int STATUS_ERROR = 500; // 失败的状态码

    // 变量
    private int status; // HTTP 状态码
    private String message; // 信息

    /**
     * 提取方法
     * @param status
     * @param message
     * @return
     */
    private static BaseResult createResult(int status,String message)   {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return  baseResult;
    }

    /**
     * 封装成功的状态码消息(无参数)
     * @return
     */
    public static BaseResult ok()  {
        return BaseResult.createResult(STATUS_OK,"请求成功！");
    }

    /**
     * 方法重载
     * 自定义 200 状态码的消息
     * @param message
     * @return
     */
    public static BaseResult ok(String message) {
        return BaseResult.createResult(STATUS_OK,message);
    }

    /**
     * 自定义成功的状态码和描述
     * @param status
     * @param message
     * @return
     */
    public static BaseResult ok(int status,String message)  {
        return BaseResult.createResult(STATUS_ERROR,message);
    }

    /**
     * 封装失败的状态码消息(无参数)
     * @return
     */
    public static BaseResult error() {
        return BaseResult.createResult(STATUS_ERROR,"服务器错误，请联系管理员!");
    }

    /**
     * 方法重载
     * 自定义 500 状态码的消息
     * @param message
     * @return
     */
    public static BaseResult error(String message)   {
        return BaseResult.createResult(STATUS_ERROR,message);
    }

    /**
     * 自定义失败的状态码和描述
     * @param status
     * @param message
     * @return
     */
    public static BaseResult error(int status,String message)    {
        return BaseResult.createResult(status,message);
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
