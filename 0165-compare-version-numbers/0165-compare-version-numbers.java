class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");

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
