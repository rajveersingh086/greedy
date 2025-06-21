package greedy;
import java.util.*;
public class matchplayer {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0,j=0;
        int count=0;
        while(i<players.length && j<trainers.length){
            if(trainers[j]>=players[i]){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}