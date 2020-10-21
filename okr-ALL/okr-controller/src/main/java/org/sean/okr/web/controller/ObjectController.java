package org.sean.okr.web.controller;

import com.alibaba.cola.dto.Response;
import org.sean.okr.infrastructure.common.exception.BusinessException;
import org.sean.okr.infrastructure.common.exception.BusinessExceptionCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("object")
public class ObjectController {

    @GetMapping("/exception")
    public Response testException(){
        throw new BusinessException(BusinessExceptionCode.NOT_EXIST);
    }

}
