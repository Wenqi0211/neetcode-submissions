class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int resLen = Integer.MAX_VALUE; //length of min window
        int resLeft = 0; //start of the min window
        int needCount = need.size();
        int have = 0;
        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }
            while (have == needCount) {
                
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    resLeft = l;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(resLeft, resLeft + resLen);
    }
}
