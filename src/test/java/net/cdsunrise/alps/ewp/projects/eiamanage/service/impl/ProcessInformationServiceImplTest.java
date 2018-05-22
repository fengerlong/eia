package net.cdsunrise.alps.ewp.projects.eiamanage.service.impl;

import net.cdsunrise.alps.ewp.projects.eiamanage.EiamanageApplicationTests;
import net.cdsunrise.alps.ewp.projects.eiamanage.repository.ProcessInformationMapper;
import net.cdsunrise.alps.ewp.projects.eiamanage.returnEntity.ProcessInformationReturns;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ProcessInformationServiceImplTest extends EiamanageApplicationTests {

    @Autowired
    private ProcessInformationMapper processInformationMapper;

    @Test
    public void getList() {
        List<ProcessInformationReturns> processInformationReturnsList =  processInformationMapper.getList();
        Assert.assertTrue(processInformationReturnsList.size() > 0);
    }
}