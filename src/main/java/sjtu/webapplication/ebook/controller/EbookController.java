package sjtu.webapplication.ebook.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.aspectj.apache.bcel.classfile.Module;
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
    public String booksGetAll() {
        return bookService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/users/getall", method = RequestMethod.POST, consumes = "application/json")
    public String usersGetAll() {
        return userService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/users/check", method = RequestMethod.POST, consumes = "application/json")
    public String userCheck(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        int result = userService.logincheck(username, password);
        return JSON.toJSONString(result);
    }

    @CrossOrigin
    @RequestMapping(value = "/books/update", method = RequestMethod.POST, consumes = "application/json")
    public String booksUpdate(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @CrossOrigin
    @RequestMapping(value = "/books/delete", method = RequestMethod.POST, consumes = "application/json")
    public String booksDelete(@RequestBody Book book) {
        bookService.deleteBook(book);
        return "book delete done";
    }

    @CrossOrigin
    @RequestMapping(value = "/books/add", method = RequestMethod.POST, consumes = "application/json")
    public String booksAdd(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @CrossOrigin
    @RequestMapping(value = "/users/update", method = RequestMethod.POST, consumes = "application/json")
    public String usersUpdate(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @CrossOrigin
    @RequestMapping(value = "/users/delete", method = RequestMethod.POST, consumes = "application/json")
    public String usersDelete(@RequestBody User user) {
        userService.deleteUser(user);
        return "user delete done";
    }

    @CrossOrigin
    @RequestMapping(value = "/users/add", method = RequestMethod.POST, consumes = "application/json")
    public String usersAdd(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
