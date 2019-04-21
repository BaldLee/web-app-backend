package sjtu.webapplication.ebook.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sjtu.webapplication.ebook.service.BookService;


@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private BookService bookService;

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
}
