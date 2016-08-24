package com.jiahao.book.dao;

import com.jiahao.book.pojo.BookType;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface BookTypeMapper {

    /**
     * 获取图书类型列表
     * @return
     */
    List<BookType> selectBookTypeList();

}
