package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("problem_checkpoints")
public class ProblemCheckpoints implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer problemId;

    private Integer checkpointId;

    private String checkpointInput;

    private String checkpointOutput;


}
