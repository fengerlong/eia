package net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class MaterialsParams implements Serializable {

    private static final long serialVersionUID = 6428345024686229252L;

    private String id;
    //文件名称
    @NotEmpty(message = "文件名称不能为空")
    private String name;
    //文件地址
    @NotEmpty(message = "文件地址不能为空")
    private String address;
    //文件类型
    @Digits(integer = 1, fraction = 0,message = "文件类型不正确")
    private Integer type;
    //关联Id
    @NotEmpty(message = "项目ID不能为空")
    private String projectId;
    //提交人Id
    @NotEmpty(message = "提交人ID不能为空")
    private String submiterId;
    //提交人姓名
    @NotEmpty(message = "提交人姓名不能为空")
    private String submiterName;
}
