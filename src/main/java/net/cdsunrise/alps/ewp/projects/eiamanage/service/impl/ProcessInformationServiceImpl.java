package net.cdsunrise.alps.ewp.projects.eiamanage.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.cdsunrise.alps.ewp.projects.eiamanage.entity.ProcessInformation;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.AccessoryParams;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.MaterialsParams;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.ProcessInformationParams;
import net.cdsunrise.alps.ewp.projects.eiamanage.repository.MaterialsMapper;
import net.cdsunrise.alps.ewp.projects.eiamanage.repository.ProcessInformationMapper;
import net.cdsunrise.alps.ewp.projects.eiamanage.returnEntity.ProcessInformationReturns;
import net.cdsunrise.alps.ewp.projects.eiamanage.service.MaterialsService;
import net.cdsunrise.alps.ewp.projects.eiamanage.service.ProcessInformationService;
import net.cdsunrise.alps.ewp.projects.eiamanage.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service("processInformationService")
public class ProcessInformationServiceImpl implements ProcessInformationService {

    @Autowired
    private ProcessInformationMapper processInformationMapper;
    @Autowired
    private MaterialsService materialsService;
    @Autowired
    private MaterialsMapper materialsMapper;

    @Override
    @Transactional
    public int add(ProcessInformationParams processInformationParams) {
        ProcessInformation processInformation = new ProcessInformation();
        BeanUtils.copyProperties(processInformationParams,processInformation);
        processInformation.setId(StringUtils.getUUID());
        processInformation.setIsDel(0);
        processInformation.setVersion(1);
        int result = processInformationMapper.insert(processInformation);

        //附件
        List<AccessoryParams> accessoryParamsList = processInformationParams.getAccessoryParamsList();
        if(!CollectionUtils.isEmpty(accessoryParamsList)){
            for (AccessoryParams accessoryParams : accessoryParamsList) {
                MaterialsParams materialsParams = new MaterialsParams();
                BeanUtils.copyProperties(accessoryParams,materialsParams);
                materialsParams.setProjectId(processInformation.getId());
                materialsService.add(materialsParams);
            }
        }
        return result;
    }

    @Override
    public List<ProcessInformationReturns> getList() {
        return processInformationMapper.getList();
    }

    @Override
    public Page<ProcessInformationReturns> getPageList() {
        PageHelper.startPage(2,2);
        return processInformationMapper.getPageList();
    }

    @Override
    public int update(ProcessInformationParams processInformationParams) {
        ProcessInformation processInformation = processInformationMapper.selectByPrimaryKey(processInformationParams.getId());
        BeanUtils.copyProperties(processInformationParams,processInformation);
        int result = processInformationMapper.updateByPrimaryKeySelective(processInformation);

        //删除之前的附件
        materialsMapper.deleteByRelevanceId(processInformation.getId());
        //重新添加附件
        List<AccessoryParams> accessoryParamsList = processInformationParams.getAccessoryParamsList();
        if(!CollectionUtils.isEmpty(accessoryParamsList)){
            for (AccessoryParams accessoryParams : accessoryParamsList) {
                MaterialsParams materialsParams = new MaterialsParams();
                BeanUtils.copyProperties(accessoryParams,materialsParams);
                materialsParams.setProjectId(processInformation.getId());
                materialsService.add(materialsParams);
            }
        }
        return result;
    }

    @Override
    public int delete(String id) {
        ProcessInformation processInformation = processInformationMapper.selectByPrimaryKey(id);
        processInformation.setIsDel(1);
        processInformation.setVersion(1);
        int result = processInformationMapper.updateByPrimaryKeySelective(processInformation);
        return result;
    }

    @Override
    public ProcessInformationReturns getDetails(String id) {
        ProcessInformationReturns processInformationReturns = processInformationMapper.getDetails(id);
        return processInformationReturns;
    }
}
