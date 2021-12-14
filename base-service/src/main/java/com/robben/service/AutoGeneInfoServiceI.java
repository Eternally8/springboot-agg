package com.robben.service;

import com.robben.dao.AutoGeneInfoDao;
import com.robben.entity.AutoGeneInfoEntity;

import java.util.List;

public interface AutoGeneInfoServiceI {

    AutoGeneInfoDao getAutoGeneInfoDao();

    AutoGeneInfoEntity getById(Integer id);

    AutoGeneInfoEntity getByEntity(AutoGeneInfoEntity autoGeneInfoEntity);

    List<AutoGeneInfoEntity> listByEntity(AutoGeneInfoEntity autoGeneInfoEntity);

    List<AutoGeneInfoEntity> listByIds(List<Integer> ids);

    int insert(AutoGeneInfoEntity autoGeneInfoEntity);

    int insertBatch(List<AutoGeneInfoEntity> list);

    int update(AutoGeneInfoEntity autoGeneInfoEntity);

    int updateBatch(List<AutoGeneInfoEntity> list);

    int deleteById(Integer id);

    int deleteByEntity(AutoGeneInfoEntity autoGeneInfoEntity);

    int deleteByIds(List<Integer> list);

    int countAll();

    int countByEntity(AutoGeneInfoEntity autoGeneInfoEntity);
}