package controllers;

import java.util.Scanner;

import entityes.Automat;
import repository.AutomatRepository;
import services.AutomatServices;
import view.GetAutomatsList;
import view.GetProductsInAutomat;

public class AutomatController {
    private AutomatServices automatServices;

    public AutomatController(AutomatServices automatServices) {
        this.automatServices = automatServices;
    }

    public Automat getUserChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Выберите один из следующих торговых аппаратов: \n");
        GetAutomatsList getAutomatsList = automatServices.GetAutomatsList();
        getAutomatsList.printList();
        int automatNum = scan.nextInt();
        AutomatRepository automatRepository = automatServices.getAutomatRepository();
        Automat automat = automatRepository.getAutomatById(automatNum);

        while (automat == null) {
            System.out.println("Выберите другой торговый автомат");
            automatNum = scan.nextInt();
            automat = automatRepository.getAutomatById(automatNum);
        }
        if (automat != null) {
            System.out.println("Сделайте заказ набирая цифру продукта. Чтобы закончить наберите finish");
            GetProductsInAutomat getProductsInAutomatList = automatServices.getProductsInAutomat(automat);
            getProductsInAutomatList.printList();
            scan.close();
        }

        return automat;
    }

    public AutomatServices getAutomatServices() {
        return automatServices;
    }
}
