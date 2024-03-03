class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
		int left =0;
		//int right = 0;
		int len = s.length();
		int max =0;
		for(int right = 0;right < len; right++) {
			char c = s.charAt(right);
			map.put(c, map.getOrDefault(c, 0) + 1);
			while(map.get(c)>1) {
				map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
				if(map.get(s.charAt(left))== 0) {
					map.remove(s.charAt(left));
				}
                left++;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
    }
}