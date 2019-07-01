package sjtu.webapplication.ebook.service;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    String addOrder(List<Integer> cartId,List<Integer> cartAmount,String ownerName);

    String getAll();

    String findByUsername(String username);

    String addByTime(Timestamp start, Timestamp end, String username);

    String getBookSaleAmount(Timestamp start, Timestamp end, int BookId);
}
