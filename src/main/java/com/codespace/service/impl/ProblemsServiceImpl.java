package com.codespace.service.impl;

import com.codespace.entity.Problems;
import com.codespace.mapper.ProblemsMapper;
import com.codespace.service.ProblemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author w_57
 * @since 2020-11-19
 */
@Service
public class ProblemsServiceImpl extends ServiceImpl<ProblemsMapper, Problems> implements ProblemsService {

}
