package ua.alexkras;

import java.util.*;

public class Counter {
    ArrayList<Integer> keys = new ArrayList<>();
    ArrayList<Integer> values = new ArrayList<>();

    public Counter (ArrayList<Integer> arrayList){

        HashMap<Integer,Integer> countMap = new HashMap<>();

        //O(n)
        for (Integer i: arrayList){
            if (countMap.containsKey(i)){
                //O(1)
                countMap.put(i,countMap.get(i)+1);
            } else {
                //O(1)
                countMap.put(i,1);

            }
        }

        //O(n)
        keys.addAll(countMap.keySet());

        //O(n)
        values.addAll(countMap.values());

        //O(n+n+n) = O(n)
    }

    public void printCounter(){
        for (int i=0; i<keys.size(); i++){
            System.out.printf("%d : %d occurrences\n",keys.get(i),values.get(i));
        }
    }


}
