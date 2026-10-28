class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int l = 0, r = points.length - 1;
        while (l <= r) {
            int q = partition(points, l, r);
            if (q == k) {
                break;
            }
            if (q > k) {
                r = q - 1;
            } else {
                l = q + 1;
            }
        }
        return Arrays.copyOfRange(points, 0, k);
    }
    private int partition(int[][] points, int l, int r) {
        int pivotDist = euclidean(points[r]);
        int i = l - 1;
        for(int j = l; j < r; j++) {
            if(euclidean(points[j]) < pivotDist) {
                swap(points,i + 1, j);
                i++;
            }

        }
        swap(points,i + 1, r);
        return i + 1;
    }
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    private int euclidean(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
