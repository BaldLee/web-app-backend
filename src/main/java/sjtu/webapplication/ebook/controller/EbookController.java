package sjtu.webapplication.ebook.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ebook")
public class EbookController {

    @RequestMapping("/")
    public String index() {
        String output = "/";
        return output;
    }
}
