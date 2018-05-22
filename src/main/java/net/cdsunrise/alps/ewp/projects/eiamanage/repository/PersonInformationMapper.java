package net.cdsunrise.alps.ewp.projects.eiamanage.repository;

import net.cdsunrise.alps.ewp.projects.eiamanage.entity.PersonInformation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personInformationMapper")
public interface PersonInformationMapper {

    int deleteByPrimaryKey(String id);

    int insert(PersonInformation record);

    int insertSelective(PersonInformation record);

    PersonInformation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonInformation record);

    int updateByPrimaryKey(PersonInformation record);

    List<PersonInformation> getList();
}