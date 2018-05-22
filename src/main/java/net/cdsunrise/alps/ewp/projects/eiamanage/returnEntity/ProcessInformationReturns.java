package net.cdsunrise.alps.ewp.projects.eiamanage.returnEntity;

import lombok.Data;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.MaterialsParams;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
public class ProcessInformationReturns implements Serializable {

    private static final long serialVersionUID = 8164670811727894211L;

    private String id;

    private String projectId;

    private String projectName;

    private String messageTheme;

    private String typeId;

    private String typeName;

    private String stateId;

    private String stateName;

    private String content;

    private String submitterId;

    private String submitterName;
    //附件信息
    private List<MaterialsReturns> materialsReturnsList;
}
