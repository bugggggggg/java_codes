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
public class Languages implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer languageId;

    private String languageName;

    private String languageCompileCommand;

    private String languageRunCommand;


}
