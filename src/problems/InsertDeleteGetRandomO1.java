package problems;

import java.util.*;

public class InsertDeleteGetRandomO1 {
    //A list gives us O1 for insert and O(1) for random.
    //for delete it takes O(N)
    //if we remember the position in the map or something we can delete in O(1)


    //map stores k ->index
    //list has all current elements
    //when we add new element, we add to map and list
    //when we remove we remove the index swap it with last element of list and update map accordingly
    //random is easy
    Map<Integer, Integer> map;
    List<Integer> list;

    public InsertDeleteGetRandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public void insert(int k) {
        map.put(k, list.size());
        list.add(k);
    }

    public void delete(int k) {
        if (!map.containsKey(k)) {
            return;
        }

        int idx = map.get(k);
        map.remove(k);

        list.set(idx, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        //update the index of swapped element
        map.put(list.get(idx), idx);
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }

    public void printl() {
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomO1 ob = new InsertDeleteGetRandomO1();

        ob.insert(1);
        ob.insert(2);
        ob.insert(3);
        ob.insert(4);

        ob.printl();
        System.out.println(ob.getRandom());
        ob.delete(2);
        ob.printl();

        ob.insert(5);
        ob.insert(6);

        ob.printl();
        ob.delete(1);
        System.out.println(ob.getRandom());
        ob.printl();
        ob.delete(6);
        ob.printl();
        System.out.println(ob.getRandom());
    }

}
