import java.awt.*;

public class CollisionWaiting implements Waiting{
    private Person person;

    public CollisionWaiting(Person person){
        this.person = person;
    }

    @Override
    public void waiting(int waitingTime) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                waitingCollision(waitingTime);
            }
        });
        thread.start();
    }

    private synchronized void waitingCollision(int waitingTime){
        try {
            Thread.sleep(waitingTime*1000);
            person.setDirection((int) (Math.random() * (3 + 1)));
            if (person.getColor() == Color.magenta){
                if (person.getSituation() != 1)
                    person.setSituation(0);
                else
                    if (person.getSituation()==1)
                        person.setSituation(1);
            }
            person.setInvisible(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
