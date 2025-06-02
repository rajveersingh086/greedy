package greedy;
import java.util.*;

class Activity {
    int start, finish;
    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class nMeetings {

    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], end[i]);
        }
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        int count = 1;
        int lastAct = activities[0].finish;

        for (int i = 1; i < n; i++) {
            if (activities[i].start > lastAct) {
                count++;
                lastAct = activities[i].finish;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of meetings: ");
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];

        System.out.println("Enter start times:");
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }
        System.out.println("Enter end times:");
        for (int i = 0; i < n; i++) {
            end[i] = sc.nextInt();
        }

        nMeetings obj = new nMeetings();
        int max = obj.maxMeetings(start, end);
        System.out.println("Maximum number of meetings: " + max);
    }
}