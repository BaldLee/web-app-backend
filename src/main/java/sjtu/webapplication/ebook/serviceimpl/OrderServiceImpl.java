package sjtu.webapplication.ebook.serviceimpl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjtu.webapplication.ebook.dao.BookDao;
import sjtu.webapplication.ebook.dao.OrderDao;
import sjtu.webapplication.ebook.dao.OrderItemDao;
import sjtu.webapplication.ebook.dao.UserDao;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.entity.Order;
import sjtu.webapplication.ebook.entity.OrderAddRequest;
import sjtu.webapplication.ebook.entity.OrderItem;
import sjtu.webapplication.ebook.service.OrderService;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public String addOrder(OrderAddRequest orderAddRequest) {
        Calendar calendar = Calendar.getInstance();
        Timestamp time = new Timestamp(calendar.getTimeInMillis());
        Order NewOrder = new Order();
//        System.out.print(userRepository.findByUsername(orderAddRequest.getOwnerName()).get(0).getId());
        NewOrder.setOwner(userDao.findByUsername(orderAddRequest.getOwnerName()).get(0).getId());
        NewOrder.setTime(time);
        NewOrder.setStatus(0);
        NewOrder = orderDao.save(NewOrder);

        for (int i = 0; i < orderAddRequest.getCartId().size(); i++) {
            OrderItem NewOrderItem = new OrderItem();
            int id = orderAddRequest.getCartId().get(i);
            int amount = orderAddRequest.getCartAmount().get(i);
            Book newBook = bookDao.findById(id);
            NewOrderItem.setItem(id);
            NewOrderItem.setOrderId(NewOrder.getId());
            NewOrderItem.setPrice(newBook.getPrice());
            NewOrderItem.setAmount(amount);
            //book amount --
            if (newBook.getAmount() < amount) {
                orderDao.delete(NewOrder);
                return "too much:" + newBook.getName();
            }
            newBook.setAmount(newBook.getAmount() - amount);
            bookDao.save(newBook);

            orderItemDao.save(NewOrderItem);
        }

        return "order add done";
    }

    @Override
    public String getAll() {
        return JSON.toJSONString(orderDao.findAll());
    }

    @Override
    public String findByUsername(String username) {
        int userid = userDao.findByUsername(username).get(0).getId();
        List<Order> orders = orderDao.findByOwner(userid);
        return JSON.toJSONString(orders);
    }

    @Override
    public String addByTime(Timestamp start, Timestamp end, String username) {
        int id = userDao.findByUsername(username).get(0).getId();
        List<Order> orders = orderDao.findByTime(start, end, id);
        double money = 0;
        for (int i = 0; i < orders.size(); i++) {
            List<OrderItem> orderItems = orderItemDao.findByOrderId(orders.get(i).getId());
            for (int j = 0; j < orderItems.size(); j++) {
                money += orderItems.get(j).getAmount() * orderItems.get(j).getPrice();
            }
        }
        return JSON.toJSONString(money);
    }
}
