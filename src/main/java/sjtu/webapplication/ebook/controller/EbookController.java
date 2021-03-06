package sjtu.webapplication.ebook.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.entity.OrderAddRequest;
import sjtu.webapplication.ebook.entity.OrderStatisticRequest;
import sjtu.webapplication.ebook.entity.User;
import sjtu.webapplication.ebook.service.BookService;
import sjtu.webapplication.ebook.service.OrderItemService;
import sjtu.webapplication.ebook.service.OrderService;
import sjtu.webapplication.ebook.service.UserService;

import javax.persistence.PreUpdate;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

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

//    @CrossOrigin
//    @RequestMapping(value="/test",method = RequestMethod.POST,consumes = "application/json")
//    public String test(@RequestBody User user){
//        return user.getUsername() + ' ' + user.getPassword();
//    }

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
    @RequestMapping(value = "/books/findbyid", method = RequestMethod.POST, consumes = "application/json")
    public String booksFindByID(@RequestBody int id) {
        return bookService.findByID(id);
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

    @CrossOrigin
    @RequestMapping(value = "/orders/add", method = RequestMethod.POST, consumes = "application/json")
    public String ordersAdd(@RequestBody OrderAddRequest orderAddRequest) {
        return orderService.addOrder(orderAddRequest);
    }

//    @CrossOrigin
//    @RequestMapping(value = "/orders/test",method = RequestMethod.POST,consumes = "application/json")
//    public OrderAddRequest test(){
//        OrderAddRequest s=new OrderAddRequest();
//        ArrayList<Integer> a=new ArrayList<Integer>();
//        a.add(1);
//        a.add(2);
//        s.setCartId(a);
//        s.setOwnerName("aaa");
//        return s;
//    }

    @CrossOrigin
    @RequestMapping(value = "orders/getall", method = RequestMethod.POST, consumes = "application/json")
    public String ordersGetAll() {
        return orderService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "orders/findbyusername", method = RequestMethod.POST, consumes = "application/json")
    public String findOrderByUsername(@RequestBody String owner) {
        return orderService.findByUsername(owner);
    }

    @CrossOrigin
    @RequestMapping(value = "orders/addbytime", method = RequestMethod.POST, consumes = "application/json")
    public String addMoneyByTime(@RequestBody OrderStatisticRequest orderStatisticRequest) {
        return orderService.addByTime(orderStatisticRequest.getStart(), orderStatisticRequest.getEnd(), orderStatisticRequest.getUsername());
    }


    @CrossOrigin
    @RequestMapping(value = "orderitems/findbyorderid", method = RequestMethod.POST, consumes = "application/json")
    public String findOrderItemByOrderId(@RequestBody Integer orderid) {
        return orderItemService.orderItemsFindByOrderId(orderid);
    }

    @CrossOrigin
    @RequestMapping(value = "orderitems/findbooksbyorderid", method = RequestMethod.POST, consumes = "application/json")
    public String findBooksByOrderId(@RequestBody Integer orderid) {
        return orderItemService.findBooksByOrderId(orderid);
    }
}
