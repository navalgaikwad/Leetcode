class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int b[] = arr.clone(); // Clone the original array
        Arrays.sort(arr); // Sort the array to get ranks
        
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1; // Start rank from 1
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) { // Only assign rank if not already in map
                map.put(arr[i], rank++);
            }
        }
        
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(b[i]); // Get the rank of the original array element
        }
        return result;
    }
}
