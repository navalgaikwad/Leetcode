class Solution {
    public List<List<Integer>> findWinners(int[][] matches) 
    {
        Map<Integer, Integer> lossCount = new HashMap<>();
        
        // Count losses for each player
        // Part 1: Iterating over matches and populating the HashMap
        for (int[] match : matches) {  // -------------------------------------------------------------|
            lossCount.putIfAbsent(match[0], 0);     // O(1) average time complexity per iteration      |
            lossCount.put(match[1], lossCount.getOrDefault(match[1], 0) + 1); // O(1) average time c.. | -- O(n)
        }  // -----------------------------------------------------------------------------------------|

        // Part 2: Iterating over the HashMap to create zeroLossesList and oneLossList
        List<Integer> zeroLossesList = new ArrayList<>();
        List<Integer> oneLossList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : lossCount.entrySet()) {  // -------------------------|
            if (entry.getValue() == 0) {  // O(1) per iteration                                       |
                zeroLossesList.add(entry.getKey());  // O(1) per iteration                            |
            } else if (entry.getValue() == 1) {  // O(1) per iteration                                | -- O(n)
                oneLossList.add(entry.getKey());  // O(1) per iteration                               | 
            }  // ------------------------------------------------------------------------------------|
        }

        // Part 3: Sorting the Lists
        Collections.sort(zeroLossesList);  // O(n log n)  n -> number of players with zero losses
        Collections.sort(oneLossList);  // O(n log n)  n -> number of players with one loss

        // Part 4: Creating and returning the answer list
        List<List<Integer>> ans = new ArrayList<>();  // O(1)
        ans.add(zeroLossesList);  // O(1)
        ans.add(oneLossList);  // O(1)


        return ans;
    }
}