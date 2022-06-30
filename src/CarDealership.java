import java.util.ArrayList;
import java.util.List;

public class CarDealership {

    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>(10);

    public Car sellCar() {
        return seller.sellCar();
    }
    public void acceptCar() {
        seller.receiveCar();
    }
    List<Car> getCars() {
        return cars;
    }
}