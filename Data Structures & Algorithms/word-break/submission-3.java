class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        //trie
        //create a trienode
        TrieNode root = new TrieNode();
        for (String w : wordDict) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }
        //fill in the form
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }
            TrieNode node = root;
            for (int k = i; k < n; k++) {
                int idx = s.charAt(k) - 'a';
                node = node.children[idx];
                if (node == null) {
                    break;
                }
                if (node.isEnd) {
                    dp[k + 1] = true;
                }
            }
        }
        return dp[n];
    }
}
