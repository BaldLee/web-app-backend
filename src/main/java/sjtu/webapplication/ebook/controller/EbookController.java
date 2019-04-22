package sjtu.webapplication.ebook.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sjtu.webapplication.ebook.bookInfo.BookInfoGet;

@RestController
@EnableAutoConfiguration
public class EbookController {
    @RequestMapping("/")
    public String index(){
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
