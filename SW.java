class SW {
    public static void main(String[] args) {
        int arr[] = {1, 3, 1, 3, 5, 3, 6, 7};
        int k = 3;
        int n = arr.length;
        int sum = 0;

        // Calculate sum of first window
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        System.out.print(sum + " ");  // Print first window sum

        // Slide the window
        for (int i = 1; i <= n - k; i++) {
            sum = sum - arr[i - 1] + arr[i + k - 1];
            System.out.print(sum + " ");
        }
    }
}
