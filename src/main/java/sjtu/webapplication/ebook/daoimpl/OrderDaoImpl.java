package sjtu.webapplication.ebook.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sjtu.webapplication.ebook.dao.OrderDao;
import sjtu.webapplication.ebook.entity.Order;
import sjtu.webapplication.ebook.repository.OrderRepository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @Override
    public Order save(Order order){
        return orderRepository.save(order);
    }

    @Override
    public void delete(Order order){
        orderRepository.delete(order);
    }

    @Override
    public List<Order> findByOwner(int userId){
        return orderRepository.findByOwner(userId);
    }

    @Override
    public List<Order> findByTimeAndUser(Timestamp start,Timestamp end,int owner){
        return orderRepository.findByTime(start, end, owner);
    }
}
