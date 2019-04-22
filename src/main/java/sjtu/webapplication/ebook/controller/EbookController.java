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
    @RequestMapping(value="/books",method = RequestMethod.POST,consumes = "Application/json")
    public String books(){
        BookInfoGet tmp = new BookInfoGet();
        return tmp.get();
    }
}
