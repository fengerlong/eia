package net.cdsunrise.alps.ewp.projects.eiamanage.config;

import net.cdsunrise.alps.ewp.projects.eiamanage.enums.ExceptionEnums;
import net.cdsunrise.alps.ewp.projects.eiamanage.exception.CustomException;
import net.cdsunrise.alps.ewp.projects.eiamanage.viewObject.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e) {
        if(e instanceof CustomException){
            e.printStackTrace();
            CustomException exception = (CustomException) e;
            return new Result(((CustomException) e).getCode(),((CustomException) e).getResultMsg());
        }else{
            //如果不是已知异常，返回系统异常
            e.printStackTrace();
            return new Result(ExceptionEnums.SYS_ERROR.getCode(), ExceptionEnums.SYS_ERROR.getMessage());
        }
    }
}
