package net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
public class ProcessInformationParams implements Serializable {

    private static final long serialVersionUID = 8164670811727894211L;

    private String id;
    @NotEmpty(message = "项目ID不能为空")
    private String projectId;
    @NotEmpty(message = "项目名称不能为空")
    private String projectName;
    @NotEmpty(message = "主题不能为空")
    private String messageTheme;
    @NotEmpty(message = "类型ID不能为空")
    private String typeId;
    @NotEmpty(message = "类型名称不能为空")
    private String typeName;
    @NotEmpty(message = "状态ID不能为空")
    private String stateId;
    @NotEmpty(message = "状态名称不能为空")
    private String stateName;
    @NotEmpty(message = "内容不能为空")
    private String content;
    @NotEmpty(message = "提交人ID不能为空")
    private String submitterId;
    @NotEmpty(message = "提交人姓名不能为空")
    private String submitterName;
    //附件信息
    private List<AccessoryParams> accessoryParamsList;
}
