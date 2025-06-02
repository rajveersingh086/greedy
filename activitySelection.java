package greedy;
import java.util.*;

class Activity {
    int start, finish;
    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class activitySelection {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        Activity[] activities = new Activity[n];

        for (int i = 0; i < n; i++) {
            activities[i] = new Activity(start[i], finish[i]);
        }
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        int count = 1;
        int lastactivity = activities[0].finish;

        for (int i = 1; i < n; i++) {
            if (activities[i].start > lastactivity) {
                count++;
                lastactivity = activities[i].finish;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of activities: ");
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] finish = new int[n];

        System.out.println("Enter start times:");
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }
        System.out.println("Enter finish times:");
        for (int i = 0; i < n; i++) {
            finish[i] = sc.nextInt();
        }

        activitySelection obj = new activitySelection();
        int maxActivities = obj.activitySelection(start, finish);
        System.out.println("Maximum number of activities: " + maxActivities);
    }
}