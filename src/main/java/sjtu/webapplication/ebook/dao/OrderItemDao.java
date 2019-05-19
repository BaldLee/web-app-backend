package sjtu.webapplication.ebook.dao;

import sjtu.webapplication.ebook.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {
    OrderItem save(OrderItem orderitem);
    List<OrderItem> findByOrderId(int orderId);
}
