class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        Map<String, List<String>> map = new HashMap<>();

        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        for (String word: wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return step;
                }
                for (int i = 0; i < cur.length(); i++) {
                    String pattern = cur.substring(0, i) + "*" + cur.substring(i + 1);
                    if (map.containsKey(pattern)) {
                        for (String next : map.get(pattern)) {
                            if (!visited.contains(next)) {
                                visited.add(next);
                                queue.offer(next);
                            }
                        }
                    }

                    
                }
               
            }
            step++;
        } 
        return 0;              
    }
    
}
