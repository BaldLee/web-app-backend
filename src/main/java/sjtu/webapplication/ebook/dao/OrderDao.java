package sjtu.webapplication.ebook.dao;

import sjtu.webapplication.ebook.entity.Order;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDao {
    List<Order> findAll();

    Order save(Order order);

    void delete(Order order);

    List<Order> findByOwner(int userid);

    List<Order> findByTimeAndUser(Timestamp start, Timestamp end, int owner);
}
