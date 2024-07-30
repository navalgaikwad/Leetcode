 class Solution {
        public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
            List<int[]> list = new LinkedList<>();
            int index = 0, index2 = 0;
            while (index < nums1.length && index2 < nums2.length) {
                if (nums1[index][0] == nums2[index2][0]) {
                    int[] one = new int[2];
                    one[0] = nums1[index][0];
                    one[1] = nums1[index++][1] + nums2[index2++][1];
                    list.add(one);
                } else if (nums1[index][0] < nums2[index2][0]) {
                    list.add(nums1[index++]);
                } else {
                    list.add(nums2[index2++]);
                }
            }

            while (index < nums1.length) {
                list.add(nums1[index++]);
            }

            while (index2 < nums2.length) {
                list.add(nums2[index2++]);
            }

            return list.toArray(new int[0][0]);
        }
    }