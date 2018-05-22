package net.cdsunrise.alps.ewp.projects.eiamanage.service;

import net.cdsunrise.alps.ewp.projects.eiamanage.entity.PersonInformation;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.PersonInformationParams;

import java.util.List;

public interface PersonInformationService {

    /**
     * 增加人员信息
     * @param personInformationParams
     * @return
     */
    int add(PersonInformationParams personInformationParams);

    /**
     * 获取人员信息列表
     * @return
     */
    List<PersonInformation> getList();

    /**
     * 更新人员信息
     * @param personInformationParams
     * @return
     */
    int update(PersonInformationParams personInformationParams);

    /**
     * 删除人员信息
     * @param id 人员Id
     * @return
     */
    int delete(String id);

    /**
     * 获取人员信息详情
     * @param id
     * @return
     */
    PersonInformation getDetails(String id);
}
