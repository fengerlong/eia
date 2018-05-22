package net.cdsunrise.alps.ewp.projects.eiamanage.repository;

import net.cdsunrise.alps.ewp.projects.eiamanage.entity.Materials;
import net.cdsunrise.alps.ewp.projects.eiamanage.returnEntity.MaterialsReturns;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("materialsMapper")
public interface MaterialsMapper {

    int deleteByPrimaryKey(String id);

    int insert(Materials record);

    int insertSelective(Materials record);

    Materials selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Materials record);

    int updateByPrimaryKey(Materials record);

    List<MaterialsReturns> getListByProjectId(@Param("projectId") String projectId);

    MaterialsReturns selectById(@Param("id") String id);

    int deleteByRelevanceId(String id);
}