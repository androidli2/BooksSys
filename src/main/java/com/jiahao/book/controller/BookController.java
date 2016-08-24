package com.jiahao.book.controller;

import com.jiahao.book.pojo.Book;
import com.jiahao.book.pojo.BookType;
import com.jiahao.book.service.BookService;
import com.jiahao.book.service.BookTypeService;
import com.jiahao.book.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookService bookService;

    @Resource
    private BookTypeService bookTypeService;


    @RequestMapping("/list")
    public String bookList(Model model, HttpServletRequest request) {

        String book_type = request.getParameter("bookType");
        Long bookType = null;
        if(book_type != null & !"".equals(book_type)) {
            bookType = Long.valueOf(book_type);
        }
        String bookName = request.getParameter("bookName");
        if("".equals(bookName)) {
            bookName = null;
        }
        Long isBorrow = null;
        String is_borrow = request.getParameter("isBorrow");
        if(is_borrow != null && !"".equals(is_borrow)) {
            isBorrow = Long.valueOf(is_borrow);
        }

        String pageNow = request.getParameter("pageNow");

        Page page = null;

        int totalCount = bookService.getBookCount(bookType, bookName, isBorrow);

        if(pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
        } else {
            page = new Page(totalCount, 1);
        }

        System.out.println("bookType===>"+book_type);
        System.out.println("bookName===>"+bookName);
        System.out.println("isBorrow===>"+is_borrow);

        List<BookType> bookTypeList = bookTypeService.bookTypeList();
        List<Book> bookList = bookService.bookList(bookType, bookName, isBorrow, page);
        //bookList.forEach(System.out::println);

        if(totalCount == 0) {
            page.setPageNow(0);
        }
        model.addAttribute("bookType", book_type);
        model.addAttribute("bookName", bookName);
        model.addAttribute("isBorrow", is_borrow);
        model.addAttribute("page", page);
        model.addAttribute("bookTypes", bookTypeList);
        model.addAttribute("books", bookList);

        return "book/booklist";
    }

    @RequestMapping("/borrow")
    public String borrow(@RequestParam("bookId") String bookId) {
        bookService.borrowBook(Long.valueOf(bookId));

        return "redirect:/book/list";

    }


}
