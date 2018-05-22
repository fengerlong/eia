package net.cdsunrise.alps.ewp.projects.eiamanage.controller;

import lombok.extern.slf4j.Slf4j;
import net.cdsunrise.alps.ewp.projects.eiamanage.entity.PersonInformation;
import net.cdsunrise.alps.ewp.projects.eiamanage.enums.ExceptionEnums;
import net.cdsunrise.alps.ewp.projects.eiamanage.exception.CustomException;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.PersonInformationParams;
import net.cdsunrise.alps.ewp.projects.eiamanage.returnEntity.PersonInformationReturns;
import net.cdsunrise.alps.ewp.projects.eiamanage.service.PersonInformationService;
import net.cdsunrise.alps.ewp.projects.eiamanage.utils.ResultUtils;
import net.cdsunrise.alps.ewp.projects.eiamanage.viewObject.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonInformationController {

    @Autowired
    private PersonInformationService personInformationService;

    @PostMapping("/add")
    private Result add(@RequestBody @Valid PersonInformationParams personInformationParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【人员信息】参数不正确，personInformationParams={}",personInformationParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        int result = personInformationService.add(personInformationParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail("添加人员信息失败");
        }
    }

    @PostMapping("/update")
    private Result update(@RequestBody @Valid PersonInformationParams personInformationParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【人员信息】参数不正确，personInformationParams={}",personInformationParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }else if(personInformationParams.getId() == null || "".equals(personInformationParams.getId())){
            log.error("【人员信息】参数不正确，personInformationParams={}",personInformationParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"ID不能为空");
        }
        int result = personInformationService.update(personInformationParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail("修改人员信息失败");
        }
    }

    @GetMapping("/getDetails")
    private Result getDetails(String id){
        if(id == null || "".equals(id)){
            log.error("【人员信息】参数不正确，id={}",id);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"ID不能为空");
        }
        PersonInformation personInformation = personInformationService.getDetails(id);
        PersonInformationReturns personInformationReturns = new PersonInformationReturns();
        BeanUtils.copyProperties(personInformation,personInformationReturns);
        //调用人员服务
        personInformationReturns.setPhone("123456");
        personInformationReturns.setEmail("1@163.com");
        return ResultUtils.successWithData(personInformationReturns);
    }

    @GetMapping("/delete")
    private Result delete(String id){
        if(id == null || "".equals(id)){
            log.error("【人员信息】参数不正确，id={}",id);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"ID不能为空");
        }
        int result = personInformationService.delete(id);
        return ResultUtils.success();
    }

    @PostMapping("/getList")
    private Result getList(){
        List<PersonInformation> personInformationList =  personInformationService.getList();
        List<PersonInformationReturns> personInformationReturnsList = new ArrayList<>();

        if(!CollectionUtils.isEmpty(personInformationList)){
            for (PersonInformation personInformation : personInformationList) {
                PersonInformationReturns personInformationReturns = new PersonInformationReturns();
                BeanUtils.copyProperties(personInformation,personInformationReturns);
                //此部分访问人员服务（根据Id）
                personInformationReturns.setPhone("123456789");
                personInformationReturns.setEmail("1@163.com");
                personInformationReturnsList.add(personInformationReturns);
            }
        }
        return ResultUtils.successWithData(personInformationReturnsList);
    }
}
