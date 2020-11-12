package problems;

import sun.awt.windows.WPrinterJob;

import java.util.*;

class DNode {
    int key;
    DNode prev;
    DNode next;
    public DNode(int key) {
        this.key = key;
    }
    public DNode() {
        this.key = 999;
    }
}
public class LRUCache {

    // 1,2,3,4,5 ->
    // 2
    private final int capacity;
    private DNode head = new DNode(0);
    private DNode tail = new DNode(999);
    private Map<Integer, Integer> map;
    private Map<Integer, DNode> keyToNode;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map  = new HashMap<>();
        this.keyToNode = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DNode node = keyToNode.get(key);
        if (map.size() == 2) {

        }
        //head - n1 - n2 - n3  - tail

        //head n1 n2 tail

        DNode nodePrev = node.prev;
        DNode nodeNext = node.next;

        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;

        DNode tPrev = tail.prev;
        tPrev.next = node;
        node.prev = tPrev;
        node.next = tail;
        tail.prev = node;

        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);

        DNode node = new DNode(key);
        keyToNode.put(key, node);
        DNode prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;


        if (map.size() > capacity) {
            map.remove(head.next.key);
            DNode next = head.next;
            head.next = next.next;
            next.next.prev = head;
            next.prev = null;
            next.next = null;
        }
    }

    public void printLL() {
        System.out.println("========head to tail========");
        DNode curr = head;
        while(curr != null) {
            System.out.print(curr.key+ " -> ");
            curr = curr.next;
        }
        curr = tail;
        System.out.println();
//        System.out.println("now reverse ");
//        while(curr != null) {
//            System.out.print(curr.key+ " -> ");
//            curr = curr.prev;
//        }
//        System.out.println();
        System.out.println("========tail to head========");

    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        //cache.printLL();
        cache.put(1,1);
        cache.get(1);
      //  cache.printLL();
        cache.put(2,2);
     //   cache.printLL();
        cache.get(1);
      //  cache.printLL();
        //cache.get(2);
        cache.put(3,3);
        cache.put(4,4);
        cache.printLL();
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.printLL();
        cache.put(5,5);
        cache.printLL();//        cache.get(2);
//        cache.put(4,4);
//        cache.get(2);
//        cache.put(5,5);
//        cache.get(2);
//
//
//
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));





    }
}
