package cn.sean.blogback.service.Impl;

import cn.sean.blogback.entity.User;
import cn.sean.blogback.mapper.UserMapper;
import cn.sean.blogback.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
