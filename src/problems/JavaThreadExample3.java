package problems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Buffer1 {
    private Queue<Integer> list;
    private int size;
    public Buffer1(int size) {
        this.list = new LinkedList<>();
        this.size = size;
    }
    public void add(int value) throws InterruptedException {
        synchronized (this) {
            while (list.size() >= size) {
                wait();
            }
            list.add(value);
            notify();
        }
    }
    public int poll() throws InterruptedException {
        synchronized (this) {
            while (list.size() == 0) {
                wait();
            }
            int value = list.poll();
            notify();
            return value;
        }
    }
}
class Buffer {

    Queue<Integer> q;
    int count  = 0;
    int max = 10;
    public Buffer() {
        q = new LinkedList<>();
    }



    public void produce() throws InterruptedException {
        while(true) {
        synchronized (this) {

                while (q.size() > 10) {
                    wait();
                }
//                if (q.size() == 1) notify();
                System.out.println("produced - "+count);
                q.add(count);
                count++;
                Thread.sleep(1000);
                notify();
            }

        }
    }

    public void consume() throws InterruptedException {

        while(true) {
            synchronized (this) {

                while(q.size() == 0) {
                    wait();
                }
               // if (q.size() == 9) notify();
                System.out.println("consumed - "+q.poll());
                Thread.sleep(1500);
                notify();
            }

        }
    }
}

class Buffer3 {
    Queue<Integer> q;
    public Buffer3() {
        q = new LinkedList<>();
    }

    int count = 0;
    int max = 10;
    public void add(int num) throws InterruptedException {
        synchronized (this) {
            if (q.size() == max) wait();
            q.add(num);
            notify();
        }
    }

    public int consume() throws InterruptedException {
        synchronized (this) {
            if (q.size() == 0) wait();
            int i = q.poll();
            notify();
            return i;
        }
    }


}
public class JavaThreadExample3 {
    public static void main(String[] args) {
//        Buffer b = new Buffer();
//        Thread producer = new Thread(()->{
//            try {
//                b.produce();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        Thread consumer = new Thread(()->{
//            try {
//                b.consume();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        producer.start();
//        consumer.start();
//
        Buffer1 b = new Buffer1(10);
        Thread producerThread = new Thread(() -> {
            try {
                int value = 0;
                while (true) {
                    b.add(value);
                    System.out.println("Produced " + value);
                    value ++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                while (true) {
                    int value = b.poll();
                    System.out.println("Consume " + value);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
