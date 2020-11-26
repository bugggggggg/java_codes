package com.demo.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.common.lang.Result;
import com.demo.entity.Problems;
import com.demo.entity.Submissions;
import com.demo.service.ProblemsService;
import com.demo.service.SubmissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author w_57
 * @since 2020-11-26
 */
@RestController
public class ProblemsController {
    @Autowired
    ProblemsService problemsService;


    @GetMapping("/problemList")
    public Result getProblemList(@RequestParam("pagenum") int pagenum,
                                 @RequestParam("pagesize")int pagesize,
                                 @RequestParam("query") String query){
        List<Problems> retList=new ArrayList<>();

        int total=problemsService.count();
        if(query.length()>0)
        {
            retList=problemsService.list(new QueryWrapper<Problems>().eq("problemId",query));
        }
        if(retList.size()==0)
        {
            List<Problems> problemsList=problemsService.list();

            //String jsonProblemList= JSON.toJSONString(problemList);

            for(int i=Math.min(total-1,(pagenum-1)*pagesize);i<Math.min(total,pagenum*pagesize);i++){
                retList.add(problemsList.get(i));
            }
        }
        else total=retList.size();
        return Result.succ(MapUtil.builder()
                .put("problemList",retList)
                .put("total",total)
                .map());
    }


    @GetMapping("/problem")
    public Result getProblem(@RequestParam("problemId") String problemId){
        Problems problem=problemsService.getById(problemId);

        return Result.succ(problem);
    }
}
