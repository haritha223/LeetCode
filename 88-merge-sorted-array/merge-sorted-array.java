class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {

            int current = nums2[i];
            int index = 0;

            while (index < m + i && nums1[index] <= current) {
                index++;
            }

            for (int j = m + i; j > index; j--) {
                nums1[j] = nums1[j - 1];
            }

            nums1[index] = current;
        }
    }
}