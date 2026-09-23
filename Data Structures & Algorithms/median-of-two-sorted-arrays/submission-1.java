class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (!(total % 2 == 0)) {
            return getKth(nums1, 0, nums2, 0, total / 2 + 1);
        } else {
            double left = getKth(nums1, 0, nums2, 0, total / 2);
            double right = getKth(nums1, 0, nums2, 0, total / 2 + 1);
            return (left + right) / 2.0;
        }
            
       
    }
    private int getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1],nums2[start2]);
        }
        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < nums1.length) {
            mid1 = nums1[start1 + k / 2 - 1];
        }
        if (start2 + k / 2 - 1 < nums2.length) {
            mid2 = nums2[start2 + k / 2 - 1];
        }
        if (mid1 < mid2) {
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}
