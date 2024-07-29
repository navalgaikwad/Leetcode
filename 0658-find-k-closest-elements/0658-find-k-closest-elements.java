class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i  =0;
        int len = arr.length - 1;
        while(len - i >= k) {// window 
            if(Math.abs(arr[i] - x) <= Math.abs(arr[len] - x)) {
                len--;
            }else {
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int j = i; j <=len; j++) {
            result.add(arr[j]);
        }
        return result;
    }
}