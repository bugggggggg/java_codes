package com.demo.controller;


import cn.hutool.core.bean.BeanUtil;
import com.demo.common.lang.Result;
import com.demo.common.lang.dto.RegisterDto;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result register(@Validated @RequestBody RegisterDto registerDto){

        //这里要检查一下邮箱格式

        //用户id从1开始递增
        Integer userCnt= userService.count()+1;

        User user = new User();
        //注册信息传给用户
        BeanUtil.copyProperties(registerDto,user);
        user.setId(userCnt.toString());

        userService.save(user);

        return Result.succ(user);
    }



}
