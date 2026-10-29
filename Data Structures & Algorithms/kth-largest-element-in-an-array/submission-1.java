class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                swap(nums, i + 1, j);
                i++;
            }
            
        }
        swap(nums, i + 1, r);
        return i + 1;
    }
    private int quickSelect(int[] nums, int l, int r, int k) {
        int q = partition(nums, l, r);
        if (q == k) {
            return nums[q];
        }
        if (q > k) {
            return quickSelect(nums, l, q - 1, k);
        } else {
            return quickSelect(nums, q + 1, r, k);
        }
    }
}
