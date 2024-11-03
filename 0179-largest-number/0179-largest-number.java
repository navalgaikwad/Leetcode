class Solution {
    class LargestNo implements Comparator<String> {
        
        @Override
        public int compare(String a, String b) {
            String val1 = a+ b;
            String val2 = b + a;
            return val2.compareTo(val1);
        }
    }
    public String largestNumber(int[] nums) {
          String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, new LargestNo());
        if(asStrs[0].equals("0")) {
            return "0";
        }
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }
}