package net.cdsunrise.alps.ewp.projects.eiamanage.service;

import com.github.pagehelper.Page;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.ProcessInformationParams;
import net.cdsunrise.alps.ewp.projects.eiamanage.returnEntity.ProcessInformationReturns;

import java.util.List;

public interface ProcessInformationService {

    /**
     * 增加过程管理
     * @param processInformationParams
     * @return
     */
    int add(ProcessInformationParams processInformationParams);

    /**
     * 获得过程管理列表
     * @return
     */
    List<ProcessInformationReturns> getList();

    /**
     * 分页查询结果
     * @return
     */
    Page<ProcessInformationReturns> getPageList();

    /**
     * 更新过程管理
     * @param processInformationParams
     * @return
     */
    int update(ProcessInformationParams processInformationParams);

    /**
     * 删除过程管理
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 获得过程管理详情
     * @param id
     * @return
     */
    ProcessInformationReturns getDetails(String id);
}
