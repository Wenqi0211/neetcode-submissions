class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : nums) {
            int oldCount = count.getOrDefault(number, 0);
            count.put(number, oldCount + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            freq[frequency].add(number);
        }

        int[] res = new int[k];
        int index = 0;
        for (int frequency = nums.length; frequency > 0 && index < k; frequency--) {
            for (int number: freq[frequency]) {
                res[index] = number;
                index++;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
