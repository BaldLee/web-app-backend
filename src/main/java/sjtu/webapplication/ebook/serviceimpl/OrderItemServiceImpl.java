package sjtu.webapplication.ebook.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sjtu.webapplication.ebook.dao.BookDao;
import sjtu.webapplication.ebook.dao.OrderItemDao;
import sjtu.webapplication.ebook.entity.OrderItem;
import sjtu.webapplication.ebook.service.OrderItemService;

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

        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < items.size(); i++) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Book",bookDao.findById(items.get(i).getItem()));
            jsonObject.put("Amount",items.get(i).getAmount());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toJSONString();
    }

}
