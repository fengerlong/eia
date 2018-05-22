package net.cdsunrise.alps.ewp.projects.eiamanage.repository;

import com.github.pagehelper.Page;
import net.cdsunrise.alps.ewp.projects.eiamanage.entity.ProcessInformation;
import net.cdsunrise.alps.ewp.projects.eiamanage.returnEntity.ProcessInformationReturns;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("processInformationMapper")
public interface ProcessInformationMapper {

    int deleteByPrimaryKey(String id);

    int insert(ProcessInformation record);

    int insertSelective(ProcessInformation record);

    ProcessInformation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProcessInformation record);

    int updateByPrimaryKey(ProcessInformation record);

    List<ProcessInformationReturns> getList();

    ProcessInformationReturns getDetails(String id);

    Page<ProcessInformationReturns> getPageList();
}