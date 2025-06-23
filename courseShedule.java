public class courseShedule {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a ->a[1]));

        PriorityQueue<Integer> set = new PriorityQueue<Integer>(Collections.reverseOrder());
        int time = 0;
        for(int[] course : courses){
            int duration =course[0];
            int lastday = course[1];

            time += duration;
            set.offer(duration);

            if(time>lastday){
                time-=set.poll();
            }
        }
        return set.size();
    }
}