import java.util.*;

class SlidingWindowSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long x = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        int[] window = new int[k];
        long sum = 0;
        long result = 0;

        
        for (int i = 0; i < k; i++) {
            window[i] = (int) x;
            sum += x;
            x = (a * x + b) % c;
        }
        result ^= sum;

        
        for (int i = k; i < n; i++) {
            sum -= window[i % k];
            window[i % k] = (int) x;
            sum += x;
            result ^= sum;
            x = (a * x + b) % c;
        }

        System.out.println(result);
    }
}
