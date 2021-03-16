import java.util.LinkedList;
import java.util.Vector;

public class Memento {
    private LinkedList<Vector<Person>> peopleBackups = new LinkedList<>();


    public void addBackup(Vector<Person> people){ peopleBackups.add(people); }

    public Vector<Person> getLastState(){
        Vector<Person> people = peopleBackups.getLast();
        peopleBackups.remove();
        return people;
    }
}
