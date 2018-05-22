package net.cdsunrise.alps.ewp.projects.eiamanage.utils;

import net.cdsunrise.alps.ewp.projects.eiamanage.viewObject.Result;

public class ResultUtils {

    /**
     * 成功返回
     * @return
     */
    public static Result success(){
        Result result = new Result(200,"success");
        return result;
    }

    /**
     * 成功返回且携带数据
     * @return
     */
    public static Result successWithData(Object data){
        Result result = new Result(200,"success",data);
        return result;
    }

    /**
     * 返回失败
     * @param message 失败信息
     * @return
     */
    public static Result fail(String message){
        Result result = new Result(100,message);
        return result;
    }
}
