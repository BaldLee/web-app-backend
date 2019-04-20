package sjtu.webapplication.ebook.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sjtu.webapplication.ebook.service.BookService;

import javax.annotation.Resource;

@RestController
@EnableAutoConfiguration
public class EbookController {

    @Resource
    private BookService bookService;

    @RequestMapping("/")
    public String index() {
        String output = "/";
        return output;
    }

    @CrossOrigin
    @RequestMapping(value = "/books", method = RequestMethod.POST, consumes = "Application/json")
    public String books() {
        BookService tmp = new BookService();
        return tmp.get();
    }

    @CrossOrigin
    @RequestMapping(value = "/books2", method = RequestMethod.POST, consumes = "Application/json")
    public String books2() {
        return JSON.toJSONString(bookService.getAll().iterator());
    }
}
