class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        if (matches(s1Count, s2Count)) return true;

        for (int r = s1.length(); r < s2.length(); r++) {
            char enter = s2.charAt(r);
            char leave = s2.charAt(r - s1.length());
            s2Count[enter - 'a']++;
            s2Count[leave - 'a']--;
            if (matches(s1Count, s2Count)) return true;
        }

        return false;
    }

    public boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
            
        }
        return true;
    }
}
