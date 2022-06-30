public class Main {

    public static void main(String[] args) {

        final CarDealership carDealership = new CarDealership();
        new Thread(carDealership::sellCar, "Покупатель 1").start();
        new Thread(carDealership::sellCar, "Покупатель 2").start();
        new Thread(carDealership::acceptCar).start();
        new Thread(carDealership::sellCar, "Покупатель 3").start();
        new Thread(carDealership::acceptCar).start();
        new Thread(carDealership::acceptCar).start();
    }
}
