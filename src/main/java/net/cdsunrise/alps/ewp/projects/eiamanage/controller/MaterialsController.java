package net.cdsunrise.alps.ewp.projects.eiamanage.controller;

import lombok.extern.slf4j.Slf4j;
import net.cdsunrise.alps.ewp.projects.eiamanage.enums.ExceptionEnums;
import net.cdsunrise.alps.ewp.projects.eiamanage.exception.CustomException;
import net.cdsunrise.alps.ewp.projects.eiamanage.paramEntity.MaterialsParams;
import net.cdsunrise.alps.ewp.projects.eiamanage.returnEntity.MaterialsReturns;
import net.cdsunrise.alps.ewp.projects.eiamanage.service.MaterialsService;
import net.cdsunrise.alps.ewp.projects.eiamanage.utils.ResultUtils;
import net.cdsunrise.alps.ewp.projects.eiamanage.viewObject.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/materials")
@Slf4j
public class MaterialsController {

    @Autowired
    private MaterialsService materialsService;

    @PostMapping("/add")
    private Result add(@RequestBody @Valid MaterialsParams materialsParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【附件】参数不正确，materialsParams={}",materialsParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        int result = materialsService.add(materialsParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail("添加失败");
        }
    }

    @PostMapping("/update")
    private Result update(@RequestBody @Valid MaterialsParams materialsParams, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【附件】参数不正确，materialsParams={}",materialsParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }else if(materialsParams.getId() == null || "".equals(materialsParams.getId())){
            log.error("【附件】参数不正确，materialsParams={}",materialsParams);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"ID不能为空");
        }
        int result = materialsService.update(materialsParams);
        if(result > 0){
            return ResultUtils.success();
        }else {
            return ResultUtils.fail("修改失败");
        }
    }

    @GetMapping("/getDetails")
    private Result getDetails(String id){
        if(id == null || "".equals(id)){
            log.error("【附件】参数不正确，id={}",id);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"ID不能为空");
        }
        MaterialsReturns materialsReturns = materialsService.getDetails(id);
        return ResultUtils.successWithData(materialsReturns);
    }

    @GetMapping("/delete")
    private Result delete(String id){
        if(id == null || "".equals(id)){
            log.error("【附件】参数不正确，id={}",id);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"ID不能为空");
        }
        int result = materialsService.delete(id);
        return ResultUtils.success();
    }

    @GetMapping("/getList")
    private Result getList(String id){
        if(id == null || "".equals(id)){
            log.error("【附件】参数不正确，id={}",id);
            throw new CustomException(ExceptionEnums.PARAM_ERROR.getCode(),"ID不能为空");
        }
        List<MaterialsReturns> materialsReturnsList =  materialsService.getListByProjectId(id);
        return ResultUtils.successWithData(materialsReturnsList);
    }
}
