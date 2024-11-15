class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> odd = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> even = new PriorityQueue<>((a,b)->b-a);
        String s = ""+num;
        char[] ch = s.toCharArray();
        for(char c : ch) {
            if(Character.getNumericValue(c)%2 == 0) {
                even.add(Character.getNumericValue(c));
            }else {
                odd.add(Character.getNumericValue(c));
            }
        }
        String result ="";
        for(char c : ch) {
            if(Character.getNumericValue(c)%2 == 0) {
                result+=even.remove();
            }else {
                result+=odd.remove();
            }
        }
        return Integer.parseInt(result);
    }
}