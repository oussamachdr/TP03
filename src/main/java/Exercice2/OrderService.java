package Exercice2;

class OrderService {
    private OrderDao orderDao;
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    public void createOrder(Order order) {
        orderDao.saveOrder(order);
    }

    public void setOrderDao(OrderDao orderDaoMock) {
        orderDao=orderDaoMock;
    }
}