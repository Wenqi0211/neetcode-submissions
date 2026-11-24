class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[i] > tails[mid]) {
                    left = mid + 1;

                } else if (nums[i] <= tails[mid]) {
                    right = mid;

                } 

            }
            if (left == size) {
                tails[size] = nums[i];
                size++;
            } else{
                tails[left] = nums[i];
            }
        }

        return size;
    }
    
}
