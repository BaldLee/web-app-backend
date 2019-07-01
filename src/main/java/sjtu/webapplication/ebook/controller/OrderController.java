package sjtu.webapplication.ebook.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sjtu.webapplication.ebook.service.OrderService;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/ebook/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public String ordersAdd(@RequestBody String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String cartIdStr = jsonObject.getString("cartId");
        String cartAmountStr = jsonObject.getString("cartAmount");
        String ownerName = jsonObject.getString("ownerName");
        List<Integer> cartId = JSONObject.parseArray(cartIdStr,Integer.class);
        List<Integer> cartAmount = JSONObject.parseArray(cartAmountStr,Integer.class);
        return orderService.addOrder(cartId,cartAmount,ownerName);
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
        int bookId = Integer.parseInt(jsonObject.getString("bookId"));
        return orderService.getBookSaleAmount(start, end, bookId);
    }
}
