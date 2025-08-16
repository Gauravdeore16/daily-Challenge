public class MissingNumber {
    public static void main(String[] args) {
        // Example Input
        int[] arr = {1, 2, 4, 5};  // Missing number is 3

        int n = arr.length + 1; // Since one number is missing
        int totalSum = n * (n + 1) / 2;

        int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }

        int missing = totalSum - arrSum;
        System.out.println("Missing number: " + missing);
    }
}
