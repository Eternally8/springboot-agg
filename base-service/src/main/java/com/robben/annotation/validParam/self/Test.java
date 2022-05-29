package com.robben.annotation.validParam.self;

import com.robben.model.UserVoEntity;

import java.lang.reflect.InvocationTargetException;

public class Test {
    private static CheckParamsParser paramsParser = new CheckParamsParser();

    public static void main(String[] args) throws Exception {
        UserVoEntity userVoEntity = new UserVoEntity();
//        userVoEntity.setId(333);

        paramsParser.check(userVoEntity);
    }

}
