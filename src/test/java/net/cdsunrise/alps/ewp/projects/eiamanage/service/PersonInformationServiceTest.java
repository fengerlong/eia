package net.cdsunrise.alps.ewp.projects.eiamanage.service;

import net.cdsunrise.alps.ewp.projects.eiamanage.EiamanageApplicationTests;
import net.cdsunrise.alps.ewp.projects.eiamanage.entity.PersonInformation;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.PersonInformationParams;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class PersonInformationServiceTest extends EiamanageApplicationTests {

    @Autowired
    private PersonInformationService personInformationService;

    @Test
    public void add() {
        PersonInformationParams personInformationParams =
                new PersonInformationParams("123456", "zhangsna", "123456", "项目名称",
                        "123456", "组织名称", "123456","角色名称", "123456", "职位名称");
        int result = personInformationService.add(personInformationParams);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void getList() {
        List<PersonInformation> list = personInformationService.getList();
        Assert.assertNotNull(list);
    }

    @Test
    public void update() {
        PersonInformationParams personInformationParams =
                new PersonInformationParams("123456", "李四", "123456", "项目名称",
                        "123456", "组织名称", "123456","高级工程师", "123456", "职位名称");
        personInformationParams.setId("e6b9d3d668ec408eb7d5553078888fd7");
        int result = personInformationService.update(personInformationParams);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void delete() {
        String id = "2bf57dd8082f45c6ad08358f1d313356";
        int result = personInformationService.delete(id);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void getDetails() {
        String id = "2bf57dd8082f45c6ad08358f1d313356";
        PersonInformation result = personInformationService.getDetails(id);
        Assert.assertNotNull(result);
    }


}