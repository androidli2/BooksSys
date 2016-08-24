package com.jiahao.book.service.impl;

import com.jiahao.book.dao.BookTypeMapper;
import com.jiahao.book.pojo.BookType;
import com.jiahao.book.service.BookTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {

    @Resource
    private BookTypeMapper bookTypeMapper;

    @Override
    public List<BookType> bookTypeList() {
        return bookTypeMapper.selectBookTypeList();
    }
}
