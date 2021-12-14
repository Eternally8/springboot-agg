package com.robben.service.impl;

import com.robben.dao.AutoGeneInfoDao;
import com.robben.entity.AutoGeneInfoEntity;
import com.robben.service.AutoGeneInfoServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AutoGeneInfoServiceImpl implements AutoGeneInfoServiceI {

    @Resource(type = AutoGeneInfoDao.class)
    private AutoGeneInfoDao autoGeneInfoDao;

    @Override
    public AutoGeneInfoDao getAutoGeneInfoDao() {
        return autoGeneInfoDao;
    }

    public AutoGeneInfoEntity getById(Integer id) {
        return autoGeneInfoDao.getById(id);
    }

    public AutoGeneInfoEntity getByEntity(AutoGeneInfoEntity autoGeneInfoEntity) {
        return autoGeneInfoDao.getByEntity(autoGeneInfoEntity);
    }

    public List<AutoGeneInfoEntity> listByEntity(AutoGeneInfoEntity autoGeneInfoEntity) {
        return autoGeneInfoDao.listByEntity(autoGeneInfoEntity);
    }

    public List<AutoGeneInfoEntity> listByIds(List<Integer> ids) {
        return autoGeneInfoDao.listByIds(ids);
    }

    public int insert(AutoGeneInfoEntity autoGeneInfoEntity) {
        Date date = new Date();
        return autoGeneInfoDao.insert(autoGeneInfoEntity);
    }

    public int insertBatch(List<AutoGeneInfoEntity> list) {
        return autoGeneInfoDao.insertBatch(list);
    }

    public int update(AutoGeneInfoEntity autoGeneInfoEntity) {
        return autoGeneInfoDao.update(autoGeneInfoEntity);
    }

    public int updateBatch(List<AutoGeneInfoEntity> list) {
        return autoGeneInfoDao.updateBatch(list);
    }

    public int deleteById(Integer id) {
        return autoGeneInfoDao.deleteById(id);
    }

    public int deleteByEntity(AutoGeneInfoEntity autoGeneInfoEntity) {
        return autoGeneInfoDao.deleteByEntity(autoGeneInfoEntity);
    }

    public int deleteByIds(List<Integer> list) {
        return autoGeneInfoDao.deleteByIds(list);
    }

    public int countAll() {
        return autoGeneInfoDao.countAll();
    }

    public int countByEntity(AutoGeneInfoEntity autoGeneInfoEntity) {
        return autoGeneInfoDao.countByEntity(autoGeneInfoEntity);
    }

}