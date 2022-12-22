
import controllers.AutomatController;
import controllers.OrderController;
import entityes.Automat;
import entityes.automats.DrinkSnackAutomat;
import entityes.automats.GameAutomat;
import entityes.automats.HotDrinkAutomat;
import entityes.products.Coffee;
import entityes.products.Drink;
import entityes.products.Doll;
import entityes.products.Snack;
import entityes.products.SoftTots;
import entityes.products.Tea;
import repository.AutomatRepository;
import repository.OrderRepository;
import services.AutomatServices;
import services.OrderServices;

public class Main {
    public static void main(String[] args) {
        DrinkSnackAutomat drinkSnackAutomat = new DrinkSnackAutomat("Торговый автомат напитков и закусок", 10);
        HotDrinkAutomat hotDrinkAutomat = new HotDrinkAutomat("Торговый автомат горячих напитков", 10);
        GameAutomat gameAutomat = new GameAutomat("Торговый автомат игрушек", 10);

        Drink stillWater = new Drink("Вода негазированная", 40, 0.5);
        Drink sparklingWater = new Drink("Вода газированная", 40, 0.5);
        Snack chips = new Snack("Чипсы", 100, 0.2);
        Snack mars = new Snack("Mars", 100, 0.2);

        Coffee cappuccino = new Coffee("Кофе каппучино", 110, 0.5, 50);
        Coffee espresso = new Coffee("Кофе эспрессо", 125, 0.5, 50);
        Tea blackTea = new Tea("Чай черный", 95, 0.5, 50);
        Tea greenTea = new Tea("Чай зелёный", 105, 0.5, 50);

        SoftTots smallTeddyBear = new SoftTots("Плюшевый мишка", 500);
        SoftTots bigTeddyBear = new SoftTots("Плюшевый мишка", 1000);
        Doll girl = new Doll("Кукла девочка", 1100);
        Doll boy = new Doll("Кукла мальчик", 1200);

        AutomatRepository automatRepository = new AutomatRepository();
        automatRepository.AddAutomat(drinkSnackAutomat);
        automatRepository.AddAutomat(hotDrinkAutomat);
        automatRepository.AddAutomat(gameAutomat);

        OrderRepository orderRepository = new OrderRepository();

        AutomatServices automatServices = new AutomatServices(automatRepository);
        OrderServices orderServices = new OrderServices(orderRepository);

        drinkSnackAutomat.AddProduct(stillWater, 3);
        drinkSnackAutomat.AddProduct(sparklingWater, 3);
        drinkSnackAutomat.AddProduct(chips, 3);
        drinkSnackAutomat.AddProduct(mars, 3);

        gameAutomat.AddProduct(smallTeddyBear, 3);
        gameAutomat.AddProduct(bigTeddyBear, 3);
        gameAutomat.AddProduct(boy, 3);
        gameAutomat.AddProduct(girl, 3);

        hotDrinkAutomat.AddProduct(cappuccino, 1);
        hotDrinkAutomat.AddProduct(espresso, 1);
        hotDrinkAutomat.AddProduct(blackTea, 1);
        hotDrinkAutomat.AddProduct(greenTea, 1);

        AutomatController automatController = new AutomatController(automatServices);
        Automat automat = automatController.getUserChoice();

        OrderController orderController = new OrderController(orderServices);
        orderController.doOrder(automat);
    }
}
