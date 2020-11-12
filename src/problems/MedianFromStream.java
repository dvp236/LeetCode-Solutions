package problems;

import java.util.*;

public class MedianFromStream {

    // 3 Approaches in general comes to mind
    // 1. Two Heaps - one min heap and one max heap
    //   this helps you get exact median in O(1)
    //   O(lon n) insert complexity O(N) space

    //2. If numbers in some fixed range and small then use buckets
    //   index will be number and value at an index is counter
    //   keep track of all the size and then return proper median


    //3. reservoir sampling
    // if can not afford O(N) space we could use reservoir sampling to get
    // the estimate of median
    // keep big sample like 10k.. and then when asked to find median
    // sort the sample and return median


    //below is approach 1
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    //1 50 4 2 3 --> 1 2 3 4 50
    public void add(int n) { //50 10
        minHeap.add(n); // 1 2 3 10
        maxHeap.add(minHeap.poll());

        if (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double getMedian() {
        // 0 1 2 3 4 5
        if ((minHeap.size() + maxHeap.size()) % 2 == 1) {
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) /(double)2;
        }

    }
//

    private List<Integer> list = new ArrayList<>();
    int n = 0;
    Random rand = new Random();
    private final static int SAMPLE_SIZE = 10000;
    //reservoir sampling
    public void add2(int a) {
        if (n < SAMPLE_SIZE) {
            list.add(a);
        } else {
            int idx = rand.nextInt(10000);
            list.set(idx, a);
        }
        n++;
    }

    public double getMedSample() {
        list.sort(Comparator.naturalOrder());
        if (list.size() % 2 == 1) {
            return list.get(list.size()/2);
        }

        return (list.get(list.size()/2) + list.get(list.size()/2 -1)) / (double) 2;

    }
    public static void main(String[] args) {
        System.out.println("Jay Swaminarayan!");
        MedianFromStream ob = new MedianFromStream();
//        ob.add(50);
//
//        ob.add(10);
//
//        //System.out.println(ob.getMedian());
//
//        ob.add(2);
//
//        ob.add(3);
//
//        //ob.add(50);
//
//        //   System.out.println(ob.getMedian());
//        ob.add(4); //2 3 4 10 50
//        ob.add(100);
//
//        System.out.println(ob.getMedian());
//     //   ob.add(5);
//      //  System.out.println(ob.getMedian());
//
//        System.out.println("---------");
//        ob.add2(1);
//        ob.add2(2);
//        ob.add2(4);
//        ob.add2(3);
//        System.out.println(ob.getMedSample());

        ob.add(1); ob.add(2);ob.add(3);ob.add(10);
        System.out.println(ob.getMedian());
    }
}
