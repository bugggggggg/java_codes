package com.demo.controller;


import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.map.MapUtil;
import com.demo.common.lang.Result;
import com.demo.entity.Submissions;
import com.demo.service.SubmissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author w_57
 * @since 2020-11-18
 */
@RestController
@RequestMapping("/problem")
public class SubmissionsController {

    @Autowired
    SubmissionsService submissionsService;


    @GetMapping("/status")
    public Result getSubmissionStatus(){
        List<Submissions> submissionsList=submissionsService.list();


        return Result.succ(MapUtil.builder()
                .put("submissionsList",submissionsList)
                .map());
    }



}
