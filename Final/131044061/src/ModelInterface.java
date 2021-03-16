import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public interface ModelInterface {
    void initialize(Memento memento);
    void resume(Memento memento);
    void stop(Memento memento);
    void undo(Memento memento);
    void addBulk(int NOP, Memento memento);
    void registerObserver(GUIMapObserver o);
    void removeObserver(GUIMapObserver o);
    void increaseNOP(Memento memento);
    Vector<Person> getPeople();
    ReentrantLock getMutexPeople();
}
