package sjtu.webapplication.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.entity.Order;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByOwner(int owner);

    @Query("select a from Order a where a.time > ?1 and a.time < ?2 and a.owner = ?3")
    List<Order> findByTime(Timestamp start, Timestamp end,int owner);
}
