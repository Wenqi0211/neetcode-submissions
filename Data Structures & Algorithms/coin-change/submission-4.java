class Solution {
    public int coinChange(int[] coins, int amount) {
        //bfs
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int step = 0;
        boolean[] visited = new boolean[amount + 1];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int cur = queue.poll();
                if (cur == amount) {
                    return step;
                }
                for (int c : coins) {
                    if (c <= amount - cur && !visited[c + cur]) {
                        visited[cur + c] = true;
                        queue.offer(c + cur);
                    }
                }
                
            }
            step++;
        }
        return -1;    
        
    }
}
