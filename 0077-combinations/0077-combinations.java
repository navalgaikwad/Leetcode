class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(n, k, new ArrayList<>(), 1);
        return result;
    }
    void helper(int n, int k, ArrayList<Integer> runningList, int index) {
        if(runningList.size() == k) {   
            result.add(new ArrayList<>(runningList));
        }
        for(int i = index; i<=n; i++) {
            //if(!runningList.contains(i)) {
                runningList.add(i);
                helper(n, k,runningList, i+1);
                runningList.remove(runningList.size()-1);
            //}
        }
    }
}

// class Solution {
//     public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> result = new ArrayList<>();
//         backTracking(result, n, k, new ArrayList<>(), 1);
//         return result;
        
//     }
    
//     void backTracking(List<List<Integer>> result, int n, int k, List<Integer> ans, int index) {
//         if(ans.size() == k) {
//             result.add(new ArrayList<>(ans));
//             return;
//         }
//         for(int i = index; i<=n; i++) {
//             ans.add(i);
//             backTracking(result, n, k , ans, i + 1);
//             ans.remove(ans.size() -1);
//         }
//     }
// }
