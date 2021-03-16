import java.awt.*;

public class Worker implements Runnable{
    private Thread thread;
    private ModelClass modelClass;
    private int timeSleep;

    public Worker(ModelClass modelClass, int timeSleep){
        this.timeSleep = timeSleep;
        thread = new Thread(this);
        this.modelClass = modelClass;
        thread.start();
    }

    private void goPeople(){
        modelClass.getMutexPeople().lock();
        for (Person person:modelClass.getPeople()) {
            if (person.getSituation() != 2
                    && person.getColor()!= Color.WHITE
                    && !person.getInvisible())
                person.walk();
        }
        modelClass.getMutexPeople().unlock();
    }

    @Override
    public void run() {
        while (true) {
            if (modelClass.getStart() && !modelClass.getStop()) {
                this.goPeople();
                modelClass.notifyGuiMapObservers();
            }
            try {
                Thread.sleep(timeSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
