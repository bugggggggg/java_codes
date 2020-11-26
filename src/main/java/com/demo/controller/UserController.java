package com.demo.controller;


import com.demo.common.lang.Result;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author w_57
 * @since 2020-11-17
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //@RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        User user = userService.getById("1");
        return Result.succ(user);
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user){
        userService.save(user);

        return Result.succ(user);
    }

}
