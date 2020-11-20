package com.codespace.controller;


import cn.hutool.core.map.MapUtil;
import com.codespace.common.lang.Result;
import com.codespace.common.lang.dto.JudgeDto;
import com.codespace.entity.Submissions;
import com.codespace.judger.CompileAndJudge;
import com.codespace.judger.data.JudgeResult;
import com.codespace.service.SubmissionsService;
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


    //@RequiresAuthentication//登录后才能提交
    @PostMapping("/judge")
    public Result judge(@Validated @RequestBody JudgeDto judgeDto){
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
