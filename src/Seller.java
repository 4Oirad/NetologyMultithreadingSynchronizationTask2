import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Seller {

    private final static int SEARCH_CAR = 1000;
    private final static int CAR_ACCEPTANCE = 1000;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final CarDealership carDealership;

    public Seller(CarDealership carDealership) {
        this.carDealership = carDealership;
    }

    public Car sellCar() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            Thread.sleep(SEARCH_CAR);
            while (carDealership.getCars().size() == 0) {
                System.out.println("Автомобилей нет в наличии");
                condition.await();
            }
            Thread.sleep(SEARCH_CAR);
            System.out.println(Thread.currentThread().getName() + " уехал на новом автомобиле");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return carDealership.getCars().remove(0);
    }

    public void receiveCar() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                Thread.sleep(CAR_ACCEPTANCE);
                carDealership.getCars().add(new Car());
                System.out.println("Производитель Toyota выпустил 1 авто");
                condition.signal();
                }
            } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}