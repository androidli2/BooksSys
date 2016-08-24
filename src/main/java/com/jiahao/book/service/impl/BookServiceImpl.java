package com.jiahao.book.service.impl;

import com.jiahao.book.dao.BookMapper;
import com.jiahao.book.pojo.Book;
import com.jiahao.book.service.BookService;
import com.jiahao.book.util.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> bookList(Long bookType, String bookName, Long isBorrow, Page page) {
        return bookMapper.selectBookList(bookType, bookName, isBorrow, page.getStartPos(), page.getPageSize());
    }

    @Override
    public void borrowBook(Long bookId) {
        bookMapper.updateBookBorrow(bookId);
    }

    @Override
    public int getBookCount(Long bookType, String bookName, Long isBorrow) {
        return bookMapper.getBookCount(bookType, bookName, isBorrow);
    }
}
