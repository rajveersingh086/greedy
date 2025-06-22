package greedy;

import java.util.*;
public class tasksheduler {
    public int leastInterval(char[] tasks, int n) {
        int []freq = new int [26];
        for (char ch : tasks){
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i =0;i<26;i++){
            if(freq[i]>0){
                pq.offer(freq[i]);
            }
        }
        int time =0;

        while (!pq.isEmpty()){
        int cycle = n+1;

        List<Integer> store = new ArrayList<>();
        int processed=0;
        for (int i =0;i<cycle && !pq.isEmpty(); i++) {
            int current = pq.poll();
            if (current - 1 > 0) {
                store.add(current - 1);
            }
            time++;
            processed++;
        }    
        for(int remaining : store){
            pq.offer(remaining);
        }
        if(pq.isEmpty()) break;
        time += (cycle-processed);    
    }
    return time;
    }
}