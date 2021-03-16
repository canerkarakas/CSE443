import java.util.LinkedList;


public class HospitalWaiting implements Waiting{

    private Person person;

    static LinkedList<Person> personLinkedList = new LinkedList<>();

    public HospitalWaiting(Person person){
        this.person = person;
    }

    @Override
    public void waiting(int waitingTime) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                producerConsumer();
            }
        });
        thread.start();
    }

    private void producerConsumer(){
        person.setQueueAtHospital(true);
        if (person.getDie())
            return;
        person.setInvisible(false);
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        person.setWaitingHospitalTime(person.getWaitingHospitalTime() - 25);
        if (person.getWaitingHospitalTime()<=0)
            person.setDie(true);
        else {
            Thread producer = new Thread(new Producer(person));
            producer.start();
            Thread consumer = new Thread(new Consumer());
            consumer.start();
        }
    }
}
