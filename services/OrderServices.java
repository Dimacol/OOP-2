package services;

import java.util.HashMap;

import entityes.Order;
import entityes.Product;
import repository.OrderRepository;
import view.GetOrderList;
import view.GetProductsInOrder;

public class OrderServices {
    private final OrderRepository orderRepository;

    public OrderServices(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public GetOrderList GetOrderList() {
        if (orderRepository.getOrdersList().isEmpty()) {
            return new GetOrderList(true, "Репозиторий заказов пустой", null);
        }
        return new GetOrderList(false, null, orderRepository.getOrdersList());
    }

    public GetProductsInOrder getProductsInOrderList(Order order) {
        HashMap<Product, Integer> products = order.getProducts();

        return new GetProductsInOrder(false, null, products);
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }
}
