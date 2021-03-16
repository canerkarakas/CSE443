import java.util.ArrayList;
import java.util.Vector;

public class MediatorClass implements Mediator{
    private Vector<Person> people = new Vector<>();

    @Override
    public void walk(Person person) {
        for (Person p: people) {
            if (p != person && !p.getInvisible()) {
                if (isCollision(p, person)){
                    int maxC = Math.max(p.getC(), person.getC());
                    setInvisiblePeople(p, person);
                    if (p.getSituation()==1){
                        if (person.getSituation()!=1){
                            setInfectPeople(p, person);
                            person.setP(collisionInfectProb(person, p, maxC));
                            if (!p.isQueueAtHospital())
                                p.setWaiting(p.getWaitingHospital());
                            else
                                p.setWaiting(p.getWaitingCollision());
                            person.setWaiting(person.getWaitingHospital());
                        }
                        else{
                            p.setWaiting(p.getWaitingCollision());
                            person.setWaiting(person.getWaitingCollision());
                        }
                    }
                    else{
                        if(person.getSituation()==1){
                            setInfectPeople(p, person);
                            p.setP(collisionInfectProb(person, p, maxC));
                            p.setWaiting(p.getWaitingHospital());
                            if (!person.isQueueAtHospital())
                                person.setWaiting(person.getWaitingHospital());
                            else
                                person.setWaiting(person.getWaitingCollision());
                        }
                        else{
                            p.setWaiting(p.getWaitingCollision());
                            person.setWaiting(person.getWaitingCollision());
                        }
                    }
                    p.waiting(maxC);
                    person.waiting(maxC);
                    break;
                }
            }
        }
    }

    @Override
    public void addPerson(Person person){
        people.add(person);
    }

    private double collisionInfectProb(Person person, Person p, int maxC){
        int minD = Math.min(p.getD(), person.getD());
        return Math.min(Person.R * (1 + (((double) maxC) * 0.1))
                * p.getM() * person.getM() * (1 - (((double) minD) * 0.1)), 1);
    }

    private boolean isCollision(Person person, Person otherPerson){
        ArrayList<ArrayList<ArrayList<Integer>>> personSquare = new ArrayList<>();
        int x = person.getX_coordinate();
        for(int i=x;i<x+5;i++){
            int y = person.getY_coordinate();
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            for (int j=y;j<y+5;j++) {
                ArrayList<Integer> temp1 = new ArrayList<>();
                temp1.add(i);
                temp1.add(j);
                temp.add(temp1);
            }
            personSquare.add(temp);
        }
        int otherPersonPointX1 = otherPerson.getX_coordinate();
        int otherPersonPointY1 = otherPerson.getY_coordinate();
        int otherPersonPointY2 = otherPersonPointY1 + 5;
        int otherPersonPointX2 = otherPersonPointX1 + 5;
        for(int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                if (otherPersonPointX1 == personSquare.get(i).get(j).get(0)){
                    if (otherPersonPointY1 == personSquare.get(i).get(j).get(1) ||
                            otherPersonPointY2 == personSquare.get(i).get(j).get(1))
                        return true;
                }
                if (otherPersonPointX2 == personSquare.get(i).get(j).get(0)){
                    if (otherPersonPointY2 == personSquare.get(i).get(j).get(1) ||
                            otherPersonPointY1 == personSquare.get(i).get(j).get(1))
                        return true;
                }
            }
        }
        return false;
    }

    private void setInvisiblePeople(Person person, Person person2){
        person.setInvisible(true);
        person2.setInvisible(true);
    }

    private void setInfectPeople(Person person, Person person2){
        person.setSituation(1);
        person2.setSituation(1);
    }

}
