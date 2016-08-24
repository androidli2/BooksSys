package com.jiahao.book.service;

import com.jiahao.book.pojo.User;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface UserService {

    User userLogin(String userCode, String password);

    int addUser(User user);

}
