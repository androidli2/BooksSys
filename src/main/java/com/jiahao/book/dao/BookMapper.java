package com.jiahao.book.dao;

import com.jiahao.book.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface BookMapper {

    /**
     * 查询图书列表
     * @param bookType 图书类型
     * @param bookName 图书名称
     * @param isBorrow 是否借阅
     * @param startPos 开始页
     * @param pageSize 页大小
     * @return
     */
    List<Book> selectBookList(@Param("bookType") Long bookType, @Param("bookName") String bookName, @Param("isBorrow") Long isBorrow, @Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize);

    /**
     * 更新是否借阅
     * @param bookId
     */
    void updateBookBorrow(@Param("bookId") Long bookId);

    /**
     * 获取图书总数
     * @param bookType
     * @param bookName
     * @param isBorrow
     * @return
     */
    int getBookCount(@Param("bookType") Long bookType, @Param("bookName") String bookName, @Param("isBorrow") Long isBorrow);
}
