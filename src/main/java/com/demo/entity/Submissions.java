package com.demo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author w_57
 * @since 2020-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Submissions implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer submissionId;

    private Integer problemId;

    private Integer uid;

    private Integer languageId;

    private LocalDateTime submissionSubmitTime;

    private Integer submissionUsedTime;

    private Integer submissionUsedMemory;

    private String submissionJudgeResult;

    private String submissionCode;


}
