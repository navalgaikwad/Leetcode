import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Create a map to store the indices of elements in arr2
        int[] indices = new int[1001]; // Assuming the range of values is [0, 1000]
        Arrays.fill(indices, -1);

        for (int i = 0; i < arr2.length; i++) {
            indices[arr2[i]] = i;
        }

        // Custom comparator based on the indices in arr2
        Comparator<Integer> customComparator = (a, b) -> {
            int indexA = indices[a];
            int indexB = indices[b];

            if (indexA != -1 && indexB != -1) {
                return Integer.compare(indexA, indexB);
            } else if (indexA != -1) {
                return -1; // a comes before b
            } else if (indexB != -1) {
                return 1; // b comes before a
            } else {
                return Integer.compare(a, b); // ascending order for elements not in arr2
            }
        };

        // Sort arr1 using the custom comparator
        Integer[] arr1Integer = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(arr1Integer, customComparator);

        // Convert back to primitive int array
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr1Integer[i];
        }

        return arr1;
    }
}
