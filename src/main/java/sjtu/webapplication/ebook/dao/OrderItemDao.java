package sjtu.webapplication.ebook.dao;

import sjtu.webapplication.ebook.entity.OrderItem;

import java.sql.Timestamp;
import java.util.List;

public interface OrderItemDao {
    OrderItem save(OrderItem orderitem);
    List<OrderItem> findByOrderId(int orderId);
    List<OrderItem> findByTimeAndBook(Timestamp start,Timestamp end,int book);
}
