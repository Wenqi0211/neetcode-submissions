class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int step = 1;
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return step;
                } 
                for (String word: wordList) {
                    if (onediff(word, cur) && !visited.contains(word)) {
                        queue.offer(word);
                        visited.add(word);
                    }

                }             
            } 
            step++;
        }
        return 0;
    }
    private boolean onediff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
