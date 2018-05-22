package net.cdsunrise.alps.ewp.projects.eiamanage.service.impl;

import net.cdsunrise.alps.ewp.projects.eiamanage.entity.PersonInformation;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.PersonInformationParams;
import net.cdsunrise.alps.ewp.projects.eiamanage.repository.PersonInformationMapper;
import net.cdsunrise.alps.ewp.projects.eiamanage.service.PersonInformationService;
import net.cdsunrise.alps.ewp.projects.eiamanage.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service("personInformationService")
public class PersonInformationServiceImpl implements PersonInformationService {

    @Autowired
    private PersonInformationMapper personInformationMapper;

    @Override
    public int add(PersonInformationParams personInformationParams) {
        PersonInformation personInformation = new PersonInformation();
        BeanUtils.copyProperties(personInformationParams,personInformation);
        personInformation.setId(StringUtils.getUUID());
        personInformation.setIsDel(0);
        personInformation.setVersion(1);
        personInformation.setEditTime(new Date());
        return personInformationMapper.insertSelective(personInformation);
    }

    @Override
    public List<PersonInformation> getList() {
        return personInformationMapper.getList();
    }

    @Override
    public int update(PersonInformationParams personInformationParams) {
        PersonInformation personInformation = personInformationMapper.selectByPrimaryKey(personInformationParams.getId());
        BeanUtils.copyProperties(personInformationParams,personInformation);
        personInformation.setEditTime(new Date());
        return personInformationMapper.updateByPrimaryKeySelective(personInformation);
    }

    @Override
    public int delete(String id) {
        PersonInformation personInformation = personInformationMapper.selectByPrimaryKey(id);
        if(personInformation != null){
            personInformation.setIsDel(1);
            return personInformationMapper.updateByPrimaryKeySelective(personInformation);
        }else {
            return 0;
        }
    }

    @Override
    public PersonInformation getDetails(String id) {
        return personInformationMapper.selectByPrimaryKey(id);
    }
}
