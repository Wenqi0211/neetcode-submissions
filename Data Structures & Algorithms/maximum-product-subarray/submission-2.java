class Solution {
    public int maxProduct(int[] nums) {
        //sliding window
        int res = nums[0];
        List<Integer> cur = new ArrayList<>();
        for (int num : nums) {
            res = Math.max(res, num);
            if (num != 0) {
                cur.add(num);
            } 
            if (num == 0 && !cur.isEmpty()) {
                res = Math.max(res, bestSeg(cur));
                cur = new ArrayList<>();
            }
            
        }
        if (!cur.isEmpty()) {
                res = Math.max(res, bestSeg(cur));
        }
        return res;
    }
    private int bestSeg(List<Integer> seg) {
        int numNeg = 0;
        for (int num : seg) {
            if (num < 0) {
                numNeg++;
            }
        }
        int need = 0;
        if (numNeg % 2 != 0) {
            need = numNeg - 1;
        } else {
            need = numNeg;
        }
        int prod = 1;
        int best = Integer.MIN_VALUE;
        int left = 0;
        int negs = 0;
        for (int i = 0; i < seg.size(); i++) {
            prod = prod * seg.get(i);
            if (seg.get(i) < 0) {
                negs++;
            }
            while (negs > need) {
                prod = prod / seg.get(left);                
                if (seg.get(left) < 0) {
                    negs--;
                }
                left++;
            }
            if (left <= i) {
                best = Math.max(best, prod);
            }    
        }
        return best;
    }
}
