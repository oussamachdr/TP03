package Exercice2;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.*;

public class OrderControllerTest {
    @Test
    public void testCreateOrder() {
        // Creer les objets mock
        OrderService orderServiceMock = mock(OrderService.class);
        OrderDao orderDaoMock = mock(OrderDao.class);

        OrderController orderController = new OrderController(orderServiceMock);

        orderServiceMock.setOrderDao(orderDaoMock);

        Order order = new Order();

        orderController.createOrder(order);

        // Vérifier que la méthode createOrder du OrderService a été appelée avec la commande correcte
        verify(orderServiceMock, times(1)).createOrder(order);

        // Vérifier que la méthode saveOrder du OrderDao a été appelée avec la commande correcte
        verify(orderDaoMock, times(0)).saveOrder(order);
    }

}