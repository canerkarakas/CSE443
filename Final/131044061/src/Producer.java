import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {
    public static Lock lock = new ReentrantLock();
    public static Condition full = lock.newCondition();
    private Person person;

    public Producer(Person person){
        this.person = person;
    }

    public void produce(){
        lock.lock();
        while (HospitalWaiting.personLinkedList.size() == ModelClass.hospitalSize) {
            try {
                if (!full.await(person.getWaitingHospitalTime(), TimeUnit.MILLISECONDS)) {
                    person.setDie(true);
                    lock.unlock();
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        HospitalWaiting.personLinkedList.add(person);
        Consumer.empty.signal();
        lock.unlock();
    }

    @Override
    public void run() {
        produce();
    }
}
