class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len =flowerbed.length-1;
        for(int i =0; i<flowerbed.length; i++) {
            if(flowerbed[i]==0 && (i ==0 || flowerbed[i-1] == 0) &&(i== len || flowerbed[i+1]==0) ) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n<=0;
    }
}

/*
 [1,0,0,0,1], n = 2
[1,0,1,0,1,0,1] 1
*/
// class Solution {
//     public boolean canPlaceFlowers(int[] arr, int n) {
//         for(int i=0; i<arr.length; i++){
//             if(arr[i]==0 && (i==0 || arr[i-1]==0) && (i==arr.length-1 || arr[i+1]==0)){
//                 arr[i]=1;
//                 n--;
//             }
//         }
//         return n<=0;
//     }
// }