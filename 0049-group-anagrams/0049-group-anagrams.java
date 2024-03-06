class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
		for(String word : strs) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String newWord = String.valueOf(arr);
			if(!map.containsKey(newWord)) {
                ArrayList<String> wrdList = new ArrayList<>();
                wrdList.add(word);
                map.put(newWord, wrdList);
            }else {
                map.get(newWord).add(word);
            }
		}
        return new ArrayList(map.values());
    }
}