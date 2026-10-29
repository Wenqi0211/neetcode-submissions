class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : count) {
            if (c > 0) {
                maxHeap.offer(c);
            }
        }
        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                maxHeap.offer(cooldown.poll()[0]);
            }
            if (!maxHeap.isEmpty()) {
                int remain = maxHeap.poll() - 1;
                if (remain > 0) {
                    cooldown.offer(new int[]{remain, time + n + 1});
                }
            }
        }
        return time;
    }
}
