package com.demo.controller;


import cn.hutool.core.map.MapUtil;
import com.demo.common.lang.Result;
import com.demo.common.lang.dto.JudgeDto;
import com.demo.entity.Problems;
import com.demo.entity.Submissions;
import com.demo.judger.CompileAndJudge;
import com.demo.judger.data.JudgeResult;
import com.demo.service.ProblemsService;
import com.demo.service.SubmissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problem")
public class JudgeController {

    @Autowired
    SubmissionsService submissionsService;

    @Autowired
    ProblemsService problemsService;

    //@RequiresAuthentication//登录后才能提交
    @PostMapping("/judge")
    public Result judge(@Validated @RequestBody JudgeDto judgeDto){

//        System.out.println(judgeDto.getSubmissionCode());
//        return Result.succ(null);

        Problems problems=problemsService.getById(judgeDto.getProblem_id());
        judgeDto.setCheckpoint_cnt(problems.getProblemCheckPointCnt());
        judgeDto.setTimeLimit(problems.getProblemTimeLimit());

        System.out.println(judgeDto);
        JudgeResult judgeResult= CompileAndJudge.compileAndJudge(
                judgeDto.getLanguage(),
                judgeDto.getTimeLimit(),
                judgeDto.getCheckpoint_cnt(),
                judgeDto.getProblem_id(),
                judgeDto.getSubmissionCode()
        );

        Submissions submissions=new Submissions();

        {
            Integer submission_cnt=submissionsService.count()+1;

            submissions.setSubmissionId(submission_cnt);

            submissions.setLanguageId(judgeDto.getLanguageId());
            submissions.setProblemId(judgeDto.getProblem_id());
            submissions.setSubmissionCode(judgeDto.getSubmissionCode());
            submissions.setSubmissionJudgeResult(judgeResult.getSubmissionJudgeResult());

            submissions.setSubmissionUsedMemory(judgeResult.getSubmissionUsedMemory());
            submissions.setSubmissionUsedTime(judgeResult.getSubmissionUsedTime());
            System.out.println(submissions);
            submissions.setUid(judgeDto.getUid());

            System.out.println(submissions);

        }

        submissionsService.save(submissions);


        return Result.succ(MapUtil.builder()
                .put("uid",judgeDto.getUid())
                .put("error",judgeResult.getError())
                .put("submissionJudgeResult",judgeResult.getSubmissionJudgeResult())
                .put("submissionUsedMemory",judgeResult.getSubmissionUsedMemory())
                .put("submissionUsedTime",judgeResult.getSubmissionUsedTime())
                .map()
        );
    }
}
