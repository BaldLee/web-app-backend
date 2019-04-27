package sjtu.webapplication.ebook.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjtu.webapplication.ebook.entity.OrderItem;
import sjtu.webapplication.ebook.repository.OrderItemRepository;

@Service
@Transactional
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public String orderItemsFindByOwner(int ownerId) {
        return JSON.toJSONString(orderItemRepository.findAll());
    }
}
