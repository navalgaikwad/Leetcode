class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i < arr.length - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }
        
        for(int i=0; i < arr.length - 1; i++) {
            if(arr[i + 1] - arr[i] == min) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
            //min = Math.min(min, arr[i + 1] - arr[i]);
        }
        
       // System.out.print(min);
        return result;
    }
}