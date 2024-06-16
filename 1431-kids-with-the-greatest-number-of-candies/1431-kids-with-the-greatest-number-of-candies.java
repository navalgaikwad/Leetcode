class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int candie:candies) {
            max = Math.max(max, candie);
        }
        List<Boolean> result = new ArrayList<>();
        for(int candie : candies) {
            result.add((candie + extraCandies) >= max);
        }
        return result;
    }
}