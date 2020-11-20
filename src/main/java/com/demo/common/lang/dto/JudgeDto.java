package com.demo.common.lang.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class JudgeDto {

    @NotBlank(message = "请选择语言")
    private String language;

    @Positive(message = "请选择语言")
    private Integer languageId;

    @Positive(message = "时限为空")
    private int timeLimit;

    @Positive(message = "测试点的数量未知")
    private int checkpoint_cnt;

    @Positive(message = "请选择要提交的题目")
    private Integer problem_id;

    @NotBlank(message = "用户id为空")
    private String uid;

    @NotBlank(message = "不允许提交空代码")
    private String submissionCode;

}
