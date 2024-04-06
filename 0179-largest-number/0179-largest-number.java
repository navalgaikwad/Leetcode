class Solution {
    class largest implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String one = a + b;
            String two = b + a;
            return two.compareTo(one);
        }
    }
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] arr = new String[len];
        for(int i =0; i<len; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new largest());
        if(arr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}