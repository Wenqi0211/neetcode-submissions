class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = piles[0];
        for (int i = 0; i < piles.length; i++) {
            r = Math.max(r, piles[i]);
            
        } 
        int l = 1;
        
        while (l < r) {
            long hours = 0;
            int mid = l + (r - l) / 2;
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + mid - 1) / mid;
            }
            if (hours <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
