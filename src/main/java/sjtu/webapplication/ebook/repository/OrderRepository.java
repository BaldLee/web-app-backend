package sjtu.webapplication.ebook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
