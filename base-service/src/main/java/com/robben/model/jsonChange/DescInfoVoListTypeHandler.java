package com.robben.model.jsonChange;

import com.alibaba.fastjson.TypeReference;
import com.robben.model.DescInfoVo;

import java.util.List;


public class DescInfoVoListTypeHandler extends ListTypeHandler<DescInfoVo> {

    @Override
    protected TypeReference<List<DescInfoVo>> specificType() {
        return new TypeReference<List<DescInfoVo>>() {
        };
    }

}