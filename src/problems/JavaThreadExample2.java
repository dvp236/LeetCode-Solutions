package problems;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.Semaphore;

class Printer {
    private final int max;
    private int count = 1;

    Semaphore semaOdd = new Semaphore(1);
    Semaphore semaEven = new Semaphore(0);

    public Printer(int max) {
        this.max = max;
    }

    public void printEven() throws InterruptedException {
        while (count < max) {
            semaEven.acquire();
            System.out.println("even - "+count);
            count++;
            semaOdd.release();
        }


    }

    public void printOdd() throws InterruptedException {
        while (count < max) {
            semaOdd.acquire();
            System.out.println("odd - "+count);
            count++;
            semaEven.release();
        }

    }
}


class SimplePrinter {
    //We want to start with 0 so odd lock will have 0 permits.
    Semaphore oddLock = new Semaphore(0);
    Semaphore evenLock = new Semaphore(1);

    public void printEven(int num) {
        try {
            evenLock.acquire();
            System.out.println(num);
            oddLock.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printOdd(int num) {
        try {
            oddLock.acquire();
            System.out.println(num);
            evenLock.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
public class JavaThreadExample2 {

    public static void main(String[] args) {
//        Printer printer = new Printer(20);
//        Thread even = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    printer.printEven();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Thread odd = new Thread(()-> {
//            try {
//                printer.printOdd();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        even.start();
//        odd.start();

        SimplePrinter sp = new SimplePrinter();
        Thread odd = new Thread(()->{
            for(int i=1; i < 20; i = i+2) {
                sp.printOdd(i);
            }
        });
        Thread even = new Thread(()-> {
            for (int i =0; i < 20; i= i +2) {
                sp.printEven(i);
            }
        });

        odd.start();
        even.start();
    }
}
