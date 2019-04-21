package sjtu.webapplication.ebook.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping(value = "/books", method = RequestMethod.POST, consumes = "Application/json")
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
}
