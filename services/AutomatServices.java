package services;

import java.util.HashMap;

import entityes.Automat;
import entityes.Product;
import repository.AutomatRepository;
import view.GetAutomatsList;
import view.GetProductsInAutomat;

public class AutomatServices {
    private final AutomatRepository automatRepository;

    public AutomatServices(AutomatRepository automatRepository) {
        this.automatRepository = automatRepository;
    }

    public GetAutomatsList GetAutomatsList() {
        if (automatRepository.getAutomatsList().isEmpty()) {
            return new GetAutomatsList(true, "Репозиторий торговых аппаратов пустой", null);
        }
        return new GetAutomatsList(false, null, automatRepository.getAutomatsList());
    }

    public GetProductsInAutomat getProductsInAutomat(Automat automat) {
        HashMap<Product, Integer> products = automat.getProductsList();

        if (products.isEmpty()) {
            return new GetProductsInAutomat(true, "В заказе нет товаров. Добавьте", null);
        }

        return new GetProductsInAutomat(false, null, products);
    }

    public AutomatRepository getAutomatRepository() {
        return automatRepository;
    }
}
