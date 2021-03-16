package part4.soru2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

public class ProxyClass implements InvocationHandler {
    private ITable iTable;
    private ReentrantLock mutex;
    private int readers = 0;
    private int writers = 0;
    private int writerRequests = 0;

    public ProxyClass(ITable iTable){
        this.iTable = iTable;
        mutex = new ReentrantLock();
    }

    public synchronized void writeLock() throws InterruptedException{
        writerRequests++;
        while(readers > 0 || writers > 0){
            wait();
        }
        writerRequests--;
        writers++;
    }

    public synchronized void writeUnlock() throws InterruptedException{
        writers--;
        notifyAll();
    }

    public synchronized void readLock() throws InterruptedException{
        while(writers > 0 || writerRequests > 0){
            wait();
        }
        readers++;
    }

    public synchronized void readUnlock(){
        readers--;
        notifyAll();
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println(Thread.currentThread().getName() + " : " + method.getName());
        try{
            if (method.getName().startsWith("get")){
                if (method.getName().equals("getElementAt")){
                    try {
                        readLock();
                        System.out.println("getelement giris " + Thread.currentThread().getName());
                        return method.invoke(iTable,args);
                    }
                    finally {
                        System.out.println("getelement cikis" + Thread.currentThread().getName());
                        readUnlock();
                    }
                }
                return method.invoke(this.iTable, args);
            }
            else if (method.getName().equals("setElementAt")){
                try {
                    writeLock();
                    System.out.println("setelement giris " + Thread.currentThread().getName());
                    return method.invoke(iTable, args);
                }
                finally {
                    System.out.println("setelement cikis " + Thread.currentThread().getName());
                    writeUnlock();
                }
            }
            else throw new IllegalAccessException();
        }
        catch (InvocationTargetException e){
            e.printStackTrace();
        }
        return null;
    }
}
