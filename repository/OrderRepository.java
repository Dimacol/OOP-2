package repository;

import java.util.ArrayList;

import entityes.Order;

public class OrderRepository {
    private ArrayList<Order> ordersList = new ArrayList<>();

    public Order getOrderByCode(Integer code) {
        for (Order order : ordersList) {
            if (order.getCode() == code) {
                return order;
            }
        }

        return null;
    }

    public boolean AddOrder(Order order) {
        if (ordersList.contains(order)) {
            return false;
        }
        ordersList.add(order);
        return true;
    }

    public ArrayList<Order> getOrdersList() {
        return ordersList;
    }
}
