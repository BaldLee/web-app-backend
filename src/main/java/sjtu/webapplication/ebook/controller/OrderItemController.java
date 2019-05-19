package sjtu.webapplication.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sjtu.webapplication.ebook.service.OrderItemService;

@RestController
@RequestMapping("/ebook/orderitems")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @CrossOrigin
    @RequestMapping(value = "/findbyorderid", method = RequestMethod.POST, consumes = "application/json")
    public String findOrderItemByOrderId(@RequestBody Integer orderId) {
        return orderItemService.orderItemsFindByOrderId(orderId);
    }

    @CrossOrigin
    @RequestMapping(value = "/findbooksbyorderid", method = RequestMethod.POST, consumes = "application/json")
    public String findBooksByOrderId(@RequestBody Integer orderId) {
        return orderItemService.findBooksByOrderId(orderId);
    }
}
