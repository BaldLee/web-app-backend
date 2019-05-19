package sjtu.webapplication.ebook.service;

import sjtu.webapplication.ebook.entity.OrderAddRequest;

import java.sql.Timestamp;

public interface OrderService {
    String addOrder(OrderAddRequest orderAddRequest);
    String getAll();
    String findByUsername(String username);
    String addByTime(Timestamp start, Timestamp end, String username);
}
