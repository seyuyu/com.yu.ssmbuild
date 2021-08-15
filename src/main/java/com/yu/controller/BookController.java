package com.yu.controller;

import com.yu.pojo.Books;
import com.yu.service.BookService;
import com.yu.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //Controller 调 service 层

    //将 service 层注入进来 @Qualifier
@Autowired
@Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部的书籍，并且返回一个书籍展示页面
    @RequestMapping("/allBook")
public String list(Model model){
    List<Books> list = bookService.queryAllBook();
    //将查到的全部数据，加入到 model 里面，然后在前端中去展示
    model.addAttribute("list",list);

    //返回到 allBook.jsp 页面
    return "allBook";
}
}
