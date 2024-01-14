class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        //seperate by .
        //two array 1 and 2
        //i and j<array1 and array2 i++ and j++
        //array1 length > array2 len i<array1 num1>0 return 1
        //array2 length > array1 len j<array2 num2>0 return 1
        //other wise zero
        int i = 0, j = 0;

        while (i < version1Array.length && j < version2Array.length) {
            int num1 = Integer.parseInt(version1Array[i]);
            int num2 = Integer.parseInt(version2Array[j]);

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }

            i++;
            j++;
        }

        if (version1Array.length > version2Array.length) {
            while (i < version1Array.length) {
                int num1 = Integer.parseInt(version1Array[i]);
                if (num1 > 0) {
                    return 1;
                }
                i++;
            }
        }

        if (version1Array.length < version2Array.length) {
            while (j < version2Array.length) {
                int num2 = Integer.parseInt(version2Array[j]);
                if (num2 > 0) {
                    return -1;
                }
                j++;
            }
        }

        return 0;
    }
}
