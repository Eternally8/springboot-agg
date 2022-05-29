package com.robben.annotation.validParam.self;

import com.alibaba.fastjson.JSONObject;
import com.robben.model.ResultEnum;
import com.robben.utils.reqResult.ResponseEntityDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ParamExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = {ParamException.class})
    public JSONObject handleValidatedException(ParamException e) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Ret",e.getErrCode());
        jsonObject.put("Msg",e.getMessage());

        return jsonObject;
    }


}
