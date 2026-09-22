class Solution {
    public int characterReplacement(String s, int k) {
        //count the number
        int[] count = new int[26];
        int l = 0;
        int maxCount = 0;
        int result = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count[c - 'A']++;
            maxCount = Math.max(maxCount, count[c - 'A']);

            while (r - l + 1 - maxCount > k) {
                char leftChar = s.charAt(l);
                count[leftChar - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;

    }
}
