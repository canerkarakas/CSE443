package part3;

import java.util.ArrayList;

public class HiTech implements Subject{
    private ArrayList<Observer> observers;
    private int time_x = 60;

    public HiTech(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:this.observers)
            observer.update(time_x);
    }

    public void changeDetected(boolean flag){
        if (flag)
            time_x = 90;
        else time_x = 60;
        notifyObservers();
    }
}
