package sjtu.webapplication.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.service.BookService;

@RestController
@RequestMapping("/ebook/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @CrossOrigin
    @RequestMapping(value = "/getall", method = RequestMethod.POST, consumes = "application/json")
    public String booksGetAll() {
        return bookService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public String booksUpdate(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @CrossOrigin
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = "application/json")
    public String booksDelete(@RequestBody Book book) {
        bookService.deleteBook(book);
        return "book delete done";
    }

    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public String booksAdd(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @CrossOrigin
    @RequestMapping(value = "/findbyid", method = RequestMethod.POST, consumes = "application/json")
    public String booksFindByID(@RequestBody int id) {
        return bookService.findByID(id);
    }
}
