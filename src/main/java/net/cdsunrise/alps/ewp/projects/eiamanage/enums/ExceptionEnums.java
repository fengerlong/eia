package net.cdsunrise.alps.ewp.projects.eiamanage.enums;

import lombok.Getter;

@Getter
public enum ExceptionEnums {

    SYS_ERROR(101,"系统异常"),
    PARAM_ERROR(102,"参数异常");

    private Integer code;

    private String message;

    ExceptionEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
