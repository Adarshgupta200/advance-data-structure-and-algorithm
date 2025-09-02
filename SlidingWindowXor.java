import java.util.*;
class SlidingWindowXor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long x = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        int[] window = new int[k];

        long xorResult = 0;
        for (int i = 0; i < k; i++) {
            window[i] = (int) x;
            x = (a * x + b) % c;
        }

        for (int i = k; i < n; i++) {
            int outgoing = window[i % k];
            int incoming = (int) x;
            window[i % k] = incoming;
            xorResult ^= (outgoing ^ incoming);
            x = (a * x + b) % c;
        }
        System.out.println(xorResult);
        sc.close();
                
    }   
}
