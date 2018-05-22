package net.cdsunrise.alps.ewp.projects.eiamanage.service.impl;

import net.cdsunrise.alps.ewp.projects.eiamanage.entity.Materials;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.MaterialsParams;
import net.cdsunrise.alps.ewp.projects.eiamanage.repository.MaterialsMapper;
import net.cdsunrise.alps.ewp.projects.eiamanage.returnEntity.MaterialsReturns;
import net.cdsunrise.alps.ewp.projects.eiamanage.service.MaterialsService;
import net.cdsunrise.alps.ewp.projects.eiamanage.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("materialsInterface")
public class MaterialsServiceImpl implements MaterialsService {

    @Autowired
    private MaterialsMapper materialsMapper;

    @Override
    public int add(MaterialsParams materialsParams) {
        Materials materials = new Materials();
        materials.setId(StringUtils.getUUID());
        materials.setEditTime(new Date());
        materials.setIsDel(0);
        materials.setMaterialsAddress(materialsParams.getAddress());
        materials.setMaterialsName(materialsParams.getName());
        materials.setMaterialsType(materialsParams.getType());
        materials.setRelevanceId(materialsParams.getProjectId());
        materials.setUploadPersonId(materialsParams.getSubmiterId());
        materials.setUploadPersonName(materialsParams.getSubmiterName());
        materials.setVersion(1);
        return materialsMapper.insertSelective(materials);
    }

    @Override
    public List<MaterialsReturns> getListByProjectId(String projectId) {
        return materialsMapper.getListByProjectId(projectId);
    }

    @Override
    public int update(MaterialsParams materialsParams) {
        Materials materials = materialsMapper.selectByPrimaryKey(materialsParams.getId());
        materials.setEditTime(new Date());
        materials.setMaterialsAddress(materialsParams.getAddress());
        materials.setMaterialsName(materialsParams.getName());
        materials.setMaterialsType(materialsParams.getType());
        materials.setRelevanceId(materialsParams.getProjectId());
        materials.setUploadPersonId(materialsParams.getSubmiterId());
        materials.setUploadPersonName(materialsParams.getSubmiterName());
        return materialsMapper.updateByPrimaryKeySelective(materials);
    }

    @Override
    public int delete(String id) {
        Materials materials = materialsMapper.selectByPrimaryKey(id);
        materials.setIsDel(1);
        return materialsMapper.updateByPrimaryKeySelective(materials);
    }

    @Override
    public MaterialsReturns getDetails(String id) {
        return materialsMapper.selectById(id);
    }
}
