package com.codespace.common.lang.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegisterDto {

    @NotBlank(message = "昵称不能为空")
    private String username;

    private String avatar;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "邮箱不能为空")
    private String email;
}
