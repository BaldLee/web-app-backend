package sjtu.webapplication.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.entity.Order;
import sjtu.webapplication.ebook.entity.OrderItem;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrderId(int orderId);

    @Query("select a from OrderItem a where a.time > ?1 and a.time < ?2 and a.item = ?3")
    List<OrderItem> findByTime(Timestamp start, Timestamp end, int book);
}
