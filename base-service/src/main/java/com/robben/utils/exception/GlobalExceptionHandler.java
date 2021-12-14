package com.robben.utils.exception;

import com.robben.model.ResultEnum;
import com.robben.utils.reqResult.ResponseEntityDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ValidationException.class})
    public ResponseEntityDto paramExceptionHandler(ValidationException e) {
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        if (!StringUtils.isEmpty(e.getMessage())) {
            return new ResponseEntityDto(ResultEnum.PARAMETER_ERROR.getCode(), e.getMessage());
        }
        return new ResponseEntityDto(ResultEnum.PARAMETER_ERROR.getCode());
    }

}
