class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        k = k - n;//  minus from k
        while(k>0) {
            n--;//decrement n
            arr[n]+=Math.min(25, k);//take min value
            k = k - Math.min(25, k);
        }
        return String.valueOf(arr);
    }
}

//     public String getSmallestString(int n, int k) {
//         char arr[] = new char[n];
//         Arrays.fill(arr,'a');

//         k=k-n;

//         while(k>0){
//             n--;
//             arr[n] += Math.min(25,k);
//             k = k-Math.min(25,k);
//         }

//         return String.valueOf(arr);
    