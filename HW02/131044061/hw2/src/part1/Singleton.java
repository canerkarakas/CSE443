package part1;

public class Singleton {
    private static Singleton singleton = null;

    private Singleton(){
        System.out.println("created new object");
    }

    public static Singleton getSingleton() {
        if (singleton == null)
            singleton = new Singleton();
        return singleton;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("You can not clone!");
    }
}

class Main{
    public static void main(String[] args) {
        Singleton object = Singleton.getSingleton();
        System.out.println(object.toString());
        try {
            Singleton clone = (Singleton) object.clone();
            System.out.println(object.toString());
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}
