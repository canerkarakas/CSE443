package part4.soru1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

public class ProxyClass implements InvocationHandler {
    private ITable iTable;
    private ReentrantLock mutex;

    public ProxyClass(ITable iTable){
        this.iTable = iTable;
        mutex = new ReentrantLock();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().startsWith("get")){
                if (method.getName().equals("getElementAt")){
                    try {
                        mutex.lock();
                        System.out.println("getelement giris " + Thread.currentThread().getName());
                        return method.invoke(iTable,args);
                    }
                    finally {
                        System.out.println("getelement cikis" + Thread.currentThread().getName());
                        mutex.unlock();
                    }
                }
                return method.invoke(this.iTable, args);
            }
            else if (method.getName().equals("setElementAt")){
                try {
                    mutex.lock();
                    System.out.println("setelement giris " + Thread.currentThread().getName());
                    return method.invoke(iTable, args);
                }
                finally {
                    System.out.println("setelement cikis " + Thread.currentThread().getName());
                    mutex.unlock();
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
