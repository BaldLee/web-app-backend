package sjtu.webapplication.ebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjtu.webapplication.ebook.entity.Order;
import sjtu.webapplication.ebook.entity.OrderAddRequest;
import sjtu.webapplication.ebook.entity.OrderItem;
import sjtu.webapplication.ebook.repository.BookRepository;
import sjtu.webapplication.ebook.repository.OrderItemRepository;
import sjtu.webapplication.ebook.repository.OrderRepository;

import java.sql.Timestamp;
import java.util.Calendar;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public String addOrder(OrderAddRequest orderAddRequest) {
        Calendar calendar = Calendar.getInstance();
        Timestamp time = new Timestamp(calendar.getTimeInMillis());
        Order NewOrder = new Order();
        NewOrder.setOwner(orderAddRequest.getUserid());
        NewOrder.setTime(time);
        NewOrder.setStatus(0);
        NewOrder = orderRepository.save(NewOrder);

        for (int i = 0; i < orderAddRequest.getIdList().size(); i++) {
            OrderItem NewOrderItem = new OrderItem();
            int id = orderAddRequest.getIdList().get(i);
            NewOrderItem.setItem(id);
            NewOrderItem.setOrder_id(NewOrder.getId());
            NewOrderItem.setPrice(bookRepository.findById(id).get(0).getPrice());
            orderItemRepository.save(NewOrderItem);
        }

        return "order add done";
    }
}
