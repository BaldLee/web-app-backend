package sjtu.webapplication.ebook.serviceimpl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjtu.webapplication.ebook.dao.BookDao;
import sjtu.webapplication.ebook.dao.OrderItemDao;
import sjtu.webapplication.ebook.entity.OrderItem;
import sjtu.webapplication.ebook.entity.OrderItemResponse;
import sjtu.webapplication.ebook.service.OrderItemService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public String orderItemsFindByOrderId(int orderId) {
        return JSON.toJSONString(orderItemDao.findByOrderId(orderId));
    }

    @Override
    public String findBooksByOrderId(int orderId) {
        List<OrderItem> items = orderItemDao.findByOrderId(orderId);

        List<OrderItemResponse> responseList = new ArrayList<OrderItemResponse>();
        for (int i = 0; i < items.size(); i++) {
            OrderItemResponse response = new OrderItemResponse();
            response.setBook(bookDao.findById(items.get(i).getItem()));
            response.setAmount(items.get(i).getAmount());
            responseList.add(response);
        }
        return JSON.toJSONString(responseList);
    }

}
