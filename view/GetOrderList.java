package view;

import java.util.ArrayList;

import entityes.Order;

public class GetOrderList extends View {
    protected ArrayList<Order> orders;

    public GetOrderList(boolean error, String errorMessage, ArrayList<Order> orders) {
        super(error, errorMessage);
        this.orders = orders;
    }

    public void printList() {
        StringBuilder res = new StringBuilder();

        if (error) {
            res.append(errorMessage);
        } else {
            for (Order el : orders) {
                res.append(el.getId() + " " + el.getCode() + "\n");
            }
        }

        System.out.println(res);
    }
}
