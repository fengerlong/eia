package net.cdsunrise.alps.ewp.projects.eiamanage.service;

import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.MaterialsParams;
import net.cdsunrise.alps.ewp.projects.eiamanage.returnEntity.MaterialsReturns;

import java.util.List;

public interface MaterialsService {

    /**
     * 增加附件
     * @param materialsParams
     * @return
     */
    int add(MaterialsParams materialsParams);

    /**
     * 获取附件列表(根据项目ID)
     * @return
     */
    List<MaterialsReturns> getListByProjectId(String projectId);

    /**
     * 更新附件
     * @param materialsParams
     * @return
     */
    int update(MaterialsParams materialsParams);

    /**
     * 删除附件
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 根据Id获取附件详情
     * @param id
     * @return
     */
    MaterialsReturns getDetails(String id);
}
