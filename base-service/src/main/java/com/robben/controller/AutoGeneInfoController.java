package com.robben.controller;

import com.robben.entity.AutoGeneInfoEntity;
import com.robben.service.AutoGeneInfoServiceI;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "自动生成代码示例")
@RestController
@RequestMapping("/autoGeneInfo")
public class AutoGeneInfoController {

    @Autowired
    private AutoGeneInfoServiceI autoGeneInfoService;

    @GetMapping("/get/{id}")
    public AutoGeneInfoEntity getById(@PathVariable Integer id) {
        AutoGeneInfoEntity autoGeneInfoEntity = autoGeneInfoService.getById(id);
        return autoGeneInfoEntity != null ? autoGeneInfoEntity : new AutoGeneInfoEntity();
    }

    @GetMapping("/get")
    public AutoGeneInfoEntity getByEntity(AutoGeneInfoEntity autoGeneInfoEntity) {
        return autoGeneInfoService.getByEntity(autoGeneInfoEntity);
    }

    @GetMapping("/list")
    public List<AutoGeneInfoEntity> list(AutoGeneInfoEntity autoGeneInfoEntity) {
        List<AutoGeneInfoEntity> autoGeneInfoEntityList = autoGeneInfoService.listByEntity(autoGeneInfoEntity);
        return autoGeneInfoEntityList;
    }

    @PostMapping("/insert")
    public AutoGeneInfoEntity insert(@RequestBody AutoGeneInfoEntity autoGeneInfoEntity) {
        autoGeneInfoService.insert(autoGeneInfoEntity);
        return autoGeneInfoEntity;
    }

    @PutMapping("/update")
    public int update(@RequestBody AutoGeneInfoEntity autoGeneInfoEntity) {
        return autoGeneInfoService.update(autoGeneInfoEntity);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteOne(@PathVariable Integer id) {
        return autoGeneInfoService.deleteById(id);
    }

    @DeleteMapping("/delete")
    public int deleteBatch(@RequestBody List<Integer> ids) {
        int result = 0;
        if (ids != null && ids.size() > 0) result = autoGeneInfoService.deleteByIds(ids);
        return result;
    }

}