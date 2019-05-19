package sjtu.webapplication.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sjtu.webapplication.ebook.entity.OrderAddRequest;
import sjtu.webapplication.ebook.entity.OrderStatisticRequest;
import sjtu.webapplication.ebook.service.OrderService;

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
    public String addMoneyByTime(@RequestBody OrderStatisticRequest orderStatisticRequest) {
        return orderService.addByTime(orderStatisticRequest.getStart(), orderStatisticRequest.getEnd(), orderStatisticRequest.getUsername());
    }
}
