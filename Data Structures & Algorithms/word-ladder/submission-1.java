class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> words = new HashSet<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        for (String word: wordList) {
            words.add(word);
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
                    char[] chars = cur.toCharArray();
                    
                    for (char ch = 'a'; ch <= 'z'; ch++ ) {
                        chars[i] = ch;
                        String next = new String(chars);
                        if (words.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    
                }
               
            }
            step++;
        } 
        return 0;              
    }
    
}
