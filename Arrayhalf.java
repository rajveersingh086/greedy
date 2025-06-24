
import java.util.*;
class Arrayhalf {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> set = new HashMap<>();
        for (int i=0;i<n;i++){
            set.put(arr[i],set.getOrDefault(arr[i] ,0)+1);
        }
        PriorityQueue<Integer>maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : set.values()) {
            maxheap.offer(freq);
        }
        int remove =0,half = n/2 ,count =0;
        while (remove < half){
            remove += maxheap.poll();
            count++;
        } 
        return count;
    }
}