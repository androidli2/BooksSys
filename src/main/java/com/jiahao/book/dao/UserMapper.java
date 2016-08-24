package com.jiahao.book.dao;

import com.jiahao.book.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface UserMapper {

    /**
     * 获取匹配账号密码的用户
     * @param userCode 登录账号
     * @param password 登录密码
     * @return
     */
    User selectUserByUserCodeAndPassword(@Param("userCode") String userCode, @Param("password") String password);

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 更新最后登录时间
     * @param date
     * @param userId
     */
    void updateLastLogintime(@Param("date") String date, @Param("userId") Long userId);
}
