package com.demo.entity;

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
public class Problems implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer problemId;

    private String problemName;

    private Integer problemTimeLimit;

    private Integer problemMemoryLimit;

    private String problemDescription;

    private String problemInputFormat;

    private String problemOutputFormat;

    private String problemSampleInput;

    private String problemSampleOutput;

    private String problemHint;


}
