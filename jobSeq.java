package greedy;

import java.util.*;

class Job implements Comparable<Job> {
    char id;
    int deadline;
    int profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public int compareTo(Job o) {
        return o.profit - this.profit;
    }
}

class jobSeq {

    public ArrayList<Character> jobSequencing(char[] ids, int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(ids[i], deadline[i], profit[i]);
        }

        Arrays.sort(jobs);

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        char[] result = new char[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];

        ArrayList<Character> scheduledJobs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(maxDeadline, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].id;
                    slot[j] = true;
                    scheduledJobs.add(jobs[i].id);
                    break;
                }
            }
        }

        return scheduledJobs;
    }

    public static void main(String[] args) {
        char[] ids = {'a', 'b', 'c', 'd'};
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};
        jobSeq js = new jobSeq();
        ArrayList<Character> res = js.jobSequencing(ids, deadline, profit);
        System.out.println("Scheduled jobs: " + res);
    }
}