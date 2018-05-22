package net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class PersonInformationParams implements Serializable {

    private static final long serialVersionUID = -1854205386370492048L;

    private String id;
    //人员ID
    @NotEmpty(message = "人员ID不能为空")
    private String personId;
    //人员名称
    @NotEmpty(message = "人员姓名不能为空")
    private String personName;
    //项目Id
    @NotEmpty(message = "项目ID不能为空")
    private String projectId;
    //项目名称
    @NotEmpty(message = "项目名称不能为空")
    private String projectName;
    //组织ID
    @NotEmpty(message = "组织ID不能为空")
    private String organizationId;
    //组织名称
    @NotEmpty(message = "组织姓名不能为空")
    private String organizationName;
    //角色Id
    @NotEmpty(message = "角色ID不能为空")
    private String roleId;
    //角色名称
    @NotEmpty(message = "角色名称不能为空")
    private String roleName;
    //职位Id
    @NotEmpty(message = "职位ID不能为空")
    private String titleId;
    //职位名称
    @NotEmpty(message = "职位名称不能为空")
    private String titleName;

    public PersonInformationParams() {

    }

    public PersonInformationParams(String personId, String personName, String projectId, String projectName, String organizationId, String organizationName, String roleId, String roleName, String titleId, String titleName) {
        this.personId = personId;
        this.personName = personName;
        this.projectId = projectId;
        this.projectName = projectName;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.roleId = roleId;
        this.roleName = roleName;
        this.titleId = titleId;
        this.titleName = titleName;
    }
}
