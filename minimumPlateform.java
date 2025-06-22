package greedy;
import java.util.*;
public class minimumPlateform {

    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int N=arr.length;
        int i =0,j=0;
        int count=0;
        int maxcount =0;
        while(i<N && j<N){
            if(arr[i]<=dep[j]){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            maxcount = Math.max(maxcount,count);
        }
        return maxcount;
    }
}
