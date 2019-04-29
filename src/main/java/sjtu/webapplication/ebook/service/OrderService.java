package sjtu.webapplication.ebook.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.entity.Order;
import sjtu.webapplication.ebook.entity.OrderAddRequest;
import sjtu.webapplication.ebook.entity.OrderItem;
import sjtu.webapplication.ebook.repository.BookRepository;
import sjtu.webapplication.ebook.repository.OrderItemRepository;
import sjtu.webapplication.ebook.repository.OrderRepository;
import sjtu.webapplication.ebook.repository.UserRepository;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public String addOrder(OrderAddRequest orderAddRequest) {
        Calendar calendar = Calendar.getInstance();
        Timestamp time = new Timestamp(calendar.getTimeInMillis());
        Order NewOrder = new Order();
//        System.out.print(userRepository.findByUsername(orderAddRequest.getOwnerName()).get(0).getId());
        NewOrder.setOwner(userRepository.findByUsername(orderAddRequest.getOwnerName()).get(0).getId());
        NewOrder.setTime(time);
        NewOrder.setStatus(0);
        NewOrder = orderRepository.save(NewOrder);

        for (int i = 0; i < orderAddRequest.getCartId().size(); i++) {
            OrderItem NewOrderItem = new OrderItem();
            int id = orderAddRequest.getCartId().get(i);
            int amount = orderAddRequest.getCartAmount().get(i);
            Book newBook = bookRepository.findById(id).get(0);
            NewOrderItem.setItem(id);
            NewOrderItem.setOrderid(NewOrder.getId());
            NewOrderItem.setPrice(newBook.getPrice());
            NewOrderItem.setAmount(amount);
            //book amount --
            if (newBook.getAmount() < amount) {
                orderRepository.delete(NewOrder);
                return "too much:" + newBook.getName();
            }
            newBook.setAmount(newBook.getAmount() - amount);
            bookRepository.save(newBook);

            orderItemRepository.save(NewOrderItem);
        }

        return "order add done";
    }

    public String getAll() {
        return JSON.toJSONString(orderRepository.findAll().iterator());
    }

    public String findByUsername(String username) {
        int userid = userRepository.findByUsername(username).get(0).getId();
        List<Order> orders = orderRepository.findByOwner(userid);
        return JSON.toJSONString(orders);
    }

    public String addByTime(Timestamp start, Timestamp end, String username) {
        int id = userRepository.findByUsername(username).get(0).getId();
        List<Order> orders = orderRepository.findByTime(start, end, id);
        double money = 0;
        for (int i = 0; i < orders.size(); i++) {
            List<OrderItem> orderItems = orderItemRepository.findByOrderid(orders.get(i).getId());
            for (int j = 0; j < orderItems.size(); j++) {
                money += orderItems.get(j).getAmount() * orderItems.get(j).getPrice();
            }
        }
        return JSON.toJSONString(money);
    }
}
