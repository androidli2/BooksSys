package com.jiahao.book.service.impl;

import com.jiahao.book.dao.UserMapper;
import com.jiahao.book.pojo.User;
import com.jiahao.book.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User userLogin(String userCode, String password) {

        User user = userMapper.selectUserByUserCodeAndPassword(userCode, password);
        if(null != user) {
            SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String date = sdf.format(new Date().getTime());
            userMapper.updateLastLogintime(date, user.getUserId());
        }

        return user;
    }

    @Override
    public int addUser(User user) {

        int r = 0;
        try{
            userMapper.addUser(user);
            r = 1;
        } catch (Exception e) {
            r = 0;
        }

        return r;
    }

}
