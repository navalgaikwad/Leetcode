class Solution {
    class Largest implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String one = a + b;
            String two = b + a;
            return two.compareTo(one);
        }
    }
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Largest());
        if(arr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String ar : arr) {
            sb.append(ar);
        }
        return sb.toString();
    }
}