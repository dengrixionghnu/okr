package org.sean.okr.web.controller;

import com.alibaba.cola.dto.Response;
import io.swagger.annotations.Api;
import org.sean.okr.infrastructure.common.exception.BusinessException;
import org.sean.okr.infrastructure.common.exception.BusinessExceptionCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("object")
@Api(value = "Objects", description = "Object信息的Controller")
public class ObjectController {

    @GetMapping("/exception")
    public Response testException(){
        throw new BusinessException(BusinessExceptionCode.NOT_EXIST);
    }

}
