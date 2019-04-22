package sjtu.webapplication.ebook.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.entity.User;
import sjtu.webapplication.ebook.service.BookService;
import sjtu.webapplication.ebook.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        String output = "/";
        return output;
    }

    @CrossOrigin
    @RequestMapping(value = "/books/getall", method = RequestMethod.POST, consumes = "application/json")
    public String books() {
        return JSON.toJSONString(bookService.getAll().iterator());
    }

    @CrossOrigin
    @RequestMapping(value = "/user/check",method = RequestMethod.POST,consumes = "application/json")
    public String userCheck(@RequestBody User user){
        String username=user.getUsername();
        String password=user.getPassword();
        int result = userService.logincheck(username,password);
        return JSON.toJSONString(result);
    }

//    @CrossOrigin
//    @RequestMapping(value="/test",method = RequestMethod.POST,consumes = "application/json")
//    public String test(@RequestBody User user){
//        return user.getUsername() + ' ' + user.getPassword();
//    }

    @CrossOrigin
    @RequestMapping(value = "/books/update",method = RequestMethod.POST,consumes = "application/json")
    public String booksUpdate(@RequestBody Book book){
        Book result = bookService.updateBook(book);
        return JSON.toJSONString(result);
    }

    @CrossOrigin
    @RequestMapping(value = "/books/delete",method = RequestMethod.POST,consumes = "application/json")
    public String booksDelete(@RequestBody Book book){
        bookService.deleteBook(book);
        return "done";
    }
}
