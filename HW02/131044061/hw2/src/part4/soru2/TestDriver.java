package part4.soru2;

import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class TestDriver {
    private Thread [] threads;
    private ITable get_proxy;

    public TestDriver(){
        this.threads = new Thread[10];
    }

    public void test(){
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        ArrayList<Integer> tempList2 = new ArrayList<>();
        tempList.add(1);
        tempList.add(2);
        tempList.add(3);
        arrayList.add(tempList);
        tempList2.add(7);
        tempList2.add(8);
        tempList2.add(9);
        arrayList.add(tempList2);
        DataBaseTable dataBaseTable = new DataBaseTable(arrayList);
        get_proxy = getProxy(dataBaseTable);
        threads[0] = new Thread(this::getSetGet);
        threads[5] = new Thread(this::getValues1);
        threads[1] = new Thread(this::setGetSetGet);
        threads[6] = new Thread(this::getValues3);
        threads[2] = new Thread(this::getSetGet);
        threads[7] = new Thread(this::getValues2);
        threads[3] = new Thread(this::setGetSetGet);
        threads[8] = new Thread(this::getValues4);
        threads[4] = new Thread(this::getSetGet);
        threads[9] = new Thread(this::setGetSetGet);
        threads[0].start();
        threads[9].start();
        threads[1].start();
        threads[5].start();
        threads[2].start();
        threads[6].start();
        threads[3].start();
        threads[8].start();
        threads[4].start();
        threads[7].start();
    }

    public void getSetGet(){
        System.out.println(Thread.currentThread().getName() + " getelement : " + get_proxy.getElementAt(0, 1));
        this.get_proxy.setElementAt(0, 1, -3);
        System.out.println(Thread.currentThread().getName() + " sonucu : getelement : " + get_proxy.getElementAt(0,1));
    }

    public void setGetSetGet(){
        this.get_proxy.setElementAt(0, 1, -1);
        System.out.println(Thread.currentThread().getName() + " ilk degisimi:  getelement : " + get_proxy.getElementAt(0, 1));
        this.get_proxy.setElementAt(0, 1, -2);
        System.out.println(Thread.currentThread().getName() + " ikinci degisimi : getelement : " + get_proxy.getElementAt(0,1));
    }

    public void getValues1(){
        System.out.println(Thread.currentThread().getName() + " getRows : " + get_proxy.getNumberOfRows());
        System.out.println(Thread.currentThread().getName() + " getColumns : " + get_proxy.getNumberOfColumns());
    }
    public void getValues2(){
        System.out.println(Thread.currentThread().getName() + " getRows : " + get_proxy.getNumberOfRows());
    }
    public void getValues3(){
        System.out.println(Thread.currentThread().getName() + " getColumns : " + get_proxy.getNumberOfColumns());
    }
    public void getValues4(){
        System.out.println(Thread.currentThread().getName() + " getColumns : " + get_proxy.getNumberOfColumns());
        System.out.println(Thread.currentThread().getName() + " getRows : " + get_proxy.getNumberOfRows());
    }

    public ITable getProxy(ITable iTable){
        return (ITable) Proxy.newProxyInstance(iTable.getClass().getClassLoader(),
                iTable.getClass().getInterfaces(),
                new ProxyClass(iTable));
    }
}
