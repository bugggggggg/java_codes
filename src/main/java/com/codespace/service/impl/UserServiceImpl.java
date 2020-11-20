package com.codespace.service.impl;

import com.codespace.entity.User;
import com.codespace.mapper.UserMapper;
import com.codespace.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author w_57
 * @since 2020-11-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
