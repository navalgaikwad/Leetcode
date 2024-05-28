class Solution {
    public int[] prisonAfterNDays(int[] arr, int n) {

        HashMap<String,Integer> hp = new HashMap<>();

        while (n > 0) {
            int[] a = new int[8];
            hp.put(Arrays.toString(arr),n--);

            for (int i = 1; i < 7; ++i)
                if(arr[i-1]==arr[i+1]) a[i] = 1;
                else a[i] = 0;
                arr = a;
                if (hp.containsKey(Arrays.toString(arr))) {
                    n %= hp.get(Arrays.toString(arr)) - n;
            }
        }
        return arr;
    }
}