package sjtu.webapplication.ebook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.entity.OrderItem;

import java.util.List;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
//    List<OrderItem> findByOwnerid(Integer ownerid);
}
