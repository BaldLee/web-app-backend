package sjtu.webapplication.ebook.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.entity.OrderItem;
import sjtu.webapplication.ebook.entity.OrderItemResponse;
import sjtu.webapplication.ebook.repository.BookRepository;
import sjtu.webapplication.ebook.repository.OrderItemRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private BookRepository bookRepository;

    public String orderItemsFindByOrderId(int orderId) {
        return JSON.toJSONString(orderItemRepository.findByOrderid(orderId));
    }

    public String findBooksByOrderId(int orderId) {
        List<OrderItem> items = orderItemRepository.findByOrderid(orderId);
        List<OrderItemResponse> responseList = new ArrayList<OrderItemResponse>();
        for (int i = 0; i < items.size(); i++) {
            OrderItemResponse response = new OrderItemResponse();
            response.setBook(bookRepository.findById(items.get(i).getItem()).get(0));
            response.setAmount(items.get(i).getAmount());
            responseList.add(response);
        }
        return JSON.toJSONString(responseList);
    }

}
