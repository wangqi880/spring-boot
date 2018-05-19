package com.j.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.j.common.BaseResponse;
import com.j.common.CodeConstraint;
import com.j.task.DynamicScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CronController {

    @Autowired
    DynamicScheduledTask dynamicScheduledTask;
    @RequestMapping("/cron")
    public Object setCron(String cron){
        dynamicScheduledTask.setCron(cron);
        BaseResponse resp  = new BaseResponse();
        resp.setCode(CodeConstraint.SUCCESS);
        resp.setInfo("success");
        return resp;
    }
}
