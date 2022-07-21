public class Main {

    private final static int WAITING_IN_LINE = 1000;

    public static void main(String[] args) throws InterruptedException {

        final CarDealership carDealership = new CarDealership();


        for (int i = 1; i <= 10; i++) {
            new Thread(carDealership::sellCar, "Покупатель " + i).start();
            Thread.sleep(WAITING_IN_LINE);
        }
        
        new Thread(carDealership::acceptCar).start();

    }
}