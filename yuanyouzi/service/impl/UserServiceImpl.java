package yuanyouzi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import yuanyouzi.entity.User;
import yuanyouzi.mapper.UserMapper;
import yuanyouzi.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
