package sjtu.webapplication.ebook.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.dao.OrderItemDao;
import sjtu.webapplication.ebook.entity.OrderItem;
import sjtu.webapplication.ebook.repository.OrderItemRepository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem save(OrderItem orderitem){
        return orderItemRepository.save(orderitem);
    }

    @Override
    public List<OrderItem> findByOrderId(int orderId){
        return orderItemRepository.findByOrderId(orderId);
    }

    @Override
    public List<OrderItem> findByTimeAndBook(Timestamp start, Timestamp end, int book) {
        return orderItemRepository.findByTime(start,end,book);
    }
}
