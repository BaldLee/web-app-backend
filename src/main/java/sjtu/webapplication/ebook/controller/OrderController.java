package sjtu.webapplication.ebook.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sjtu.webapplication.ebook.entity.OrderAddRequest;
import sjtu.webapplication.ebook.service.OrderService;

import java.sql.Timestamp;

@RestController
@RequestMapping("/ebook/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public String ordersAdd(@RequestBody OrderAddRequest orderAddRequest) {
        return orderService.addOrder(orderAddRequest);
    }

    @CrossOrigin
    @RequestMapping(value = "/getall", method = RequestMethod.POST, consumes = "application/json")
    public String ordersGetAll() {
        return orderService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/findbyusername", method = RequestMethod.POST, consumes = "application/json")
    public String findOrderByUsername(@RequestBody String owner) {
        return orderService.findByUsername(owner);
    }

    @CrossOrigin
    @RequestMapping(value = "/addbytime", method = RequestMethod.POST, consumes = "application/json")
    public String addMoneyByTime(@RequestBody String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        Timestamp start = new Timestamp(Long.parseLong(jsonObject.getString("start")));
        Timestamp end = new Timestamp(Long.parseLong(jsonObject.getString("end")));
        String username = jsonObject.getString("username");
        return orderService.addByTime(start, end, username);
    }

    @CrossOrigin
    @RequestMapping(value = "/booksale", method = RequestMethod.POST, consumes = "application/json")
    public String getBookSaleAmount(@RequestBody String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        Timestamp start = new Timestamp(Long.parseLong(jsonObject.getString("start")));
        Timestamp end = new Timestamp(Long.parseLong(jsonObject.getString("end")));
        int bookId = Integer.parseInt(jsonObject.getString("bookId)"));
        return orderService.getBookSaleAmount(start, end, bookId);
    }
}
