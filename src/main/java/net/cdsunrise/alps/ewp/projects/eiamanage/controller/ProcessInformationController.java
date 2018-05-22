package net.cdsunrise.alps.ewp.projects.eiamanage.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import net.cdsunrise.alps.ewp.projects.eiamanage.enums.ExceptionEnums;
import net.cdsunrise.alps.ewp.projects.eiamanage.exception.CustomException;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.ProcessInformationParams;
import net.cdsunrise.alps.ewp.projects.eiamanage.returnEntity.ProcessInformationReturns;
import net.cdsunrise.alps.ewp.projects.eiamanage.service.ProcessInformationService;
import net.cdsunrise.alps.ewp.projects.eiamanage.utils.PageUtils;
import net.cdsunrise.alps.ewp.projects.eiamanage.utils.ResultUtils;
import net.cdsunrise.alps.ewp.projects.eiamanage.viewObject.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/process")
@Slf4j
public class ProcessInformationController {

    @Autowired
    private ProcessInformationService processInformationService;

    @PostMapping("/add")
    private Result add(@RequestBody @Valid ProcessInformationParams processInformationParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【过程信息】参数不正确，processInformationParams={}",processInformationParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        int result = processInformationService.add(processInformationParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail("添加失败");
        }
    }

    @PostMapping("/update")
    private Result update(@RequestBody @Valid ProcessInformationParams processInformationParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【过程信息】参数不正确，processInformationParams={}",processInformationParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }else if(processInformationParams.getId() == null || "".equals(processInformationParams.getId())){
            log.error("【过程信息】参数不正确，processInformationParams={}",processInformationParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"ID不能为空");
        }
        int result = processInformationService.update(processInformationParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail("修改信息失败");
        }
    }

    @GetMapping("/getDetails")
    private Result getDetails(String id){
        if(id == null || "".equals(id)){
            log.error("【过程信息】参数不正确，id={}",id);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"ID不能为空");
        }
        ProcessInformationReturns processInformationReturns = processInformationService.getDetails(id);
        return ResultUtils.successWithData(processInformationReturns);
    }

    @GetMapping("/delete")
    private Result delete(String id){
        if(id == null || "".equals(id)){
            log.error("【人员信息】参数不正确，id={}",id);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"ID不能为空");
        }
        int result = processInformationService.delete(id);
        return ResultUtils.success();
    }

    @PostMapping("/getList")
    private Result getList(){
//        List<ProcessInformationReturns> list =  processInformationService.getList();
        Page<ProcessInformationReturns> list = processInformationService.getPageList();
        PageUtils<ProcessInformationReturns> pageInfo = new PageUtils<>(list);
        return ResultUtils.successWithData(pageInfo);
    }
}
