package com.demo.testCompile.data;

import lombok.Data;

import java.time.LocalDateTime;



@Data
public class JudgeResult {

    private Integer submissionUsedTime;

    private Integer submissionUsedMemory;

    private String submissionJudgeResult;

    private String error;//编译错误时返回错误信息

}
