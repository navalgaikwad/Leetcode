class Solution {
    public int maxDepth(String s) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                map.put(i, 1);
            }else if(s.charAt(i) == ')'){
                map.put(i, -1);
            }
        }
        int sum = 0;
        int max = 0;
        System.out.print(map);
        for(Integer values : map.values()) {
            sum+=values;
            max= Math.max(max, sum);
        }
        return max;
    }
}