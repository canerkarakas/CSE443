import java.util.Random;
import java.util.concurrent.locks.Condition;
import static java.lang.Thread.sleep;

public class Consumer implements Runnable{

    public static Condition empty = Producer.lock.newCondition();

    private void consumer(){
        Producer.lock.lock();
        try {
            while (HospitalWaiting.personLinkedList.isEmpty())
                empty.await();
            Person person = HospitalWaiting.personLinkedList.removeFirst();
            Producer.full.signal();
            Producer.lock.unlock();
            person.goHospital();
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random random = new Random();
            person.setX_coordinate(random.nextInt(1000));
            person.setY_coordinate(random.nextInt(600));
            person.setDirection(random.nextInt(4));
            person.setSituation(0);
            person.setQueueAtHospital(false);
            person.setInvisible(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        consumer();
    }
}
