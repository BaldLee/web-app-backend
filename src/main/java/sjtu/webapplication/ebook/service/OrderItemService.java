package sjtu.webapplication.ebook.service;

public interface OrderItemService {
    String orderItemsFindByOrderId(int orderId);
    String findBooksByOrderId(int orderId);
}
