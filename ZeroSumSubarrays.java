import java.util.*;

public class ZeroSumSubarrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};  // Example Input

        List<int[]> result = findZeroSumSubarrays(arr);

        if (result.isEmpty()) {
            System.out.println("[]");
        } else {
            for (int[] subarray : result) {
                System.out.println("(" + subarray[0] + ", " + subarray[1] + ")");
            }
        }
    }

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Long, List<Integer>> map = new HashMap<>();

        long prefixSum = 0;

        // Initialize with prefixSum = 0 at index -1 (to handle subarrays starting from index 0)
        map.put(0L, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum)) {
                for (int startIdx : map.get(prefixSum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            // Add current index to the list of this prefixSum
            map.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }
}
