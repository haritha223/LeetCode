class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int k = 0;

        for (int i = 0; i < n; i++) {
            res[k] = nums[i];
            res[k + 1] = nums[i + n];
            k += 2;
        }

        return res;
    }
}