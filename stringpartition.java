package greedy;
import java.util.*;
public class stringpartition {

    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int [] last = new int [26];
        for (int i =0;i<n;++i){
            last[s.charAt(i)-'a']=i;
        }
        int partiEnd =0, partiSt=0;
        List<Integer> partiSize = new ArrayList<>();
        for (int i =0;i<n;i++){
            partiEnd = Math.max(partiEnd,last[s.charAt(i) - 'a']);

            if(i==partiEnd){
                partiSize.add(i-partiSt+1);
                partiSt=i+1;
            }
        }
        return partiSize;
    }
}