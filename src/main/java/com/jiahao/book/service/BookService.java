package com.jiahao.book.service;

import com.jiahao.book.pojo.Book;
import com.jiahao.book.util.Page;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface BookService {

    List<Book> bookList(Long bookType, String bookName, Long isBorrow, Page page);

    void borrowBook(Long bookId);

    int getBookCount(Long bookType, String bookName, Long isBorrow);

}
