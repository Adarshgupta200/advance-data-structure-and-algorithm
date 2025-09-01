import java.util.*;

class SlidingWindowOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // Number of elements
        int k = sc.nextInt();  // Window size

        long x = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        int[] arr = new int[n];
        arr[0] = (int) x;

        
        for (int i = 1; i < n; i++) {
            x = (a * x + b) % c;
            arr[i] = (int) x;
        }

        int[] bitCount = new int[32];
        long ans = 0;

        
        for (int i = 0; i < k; i++) {
            addBits(bitCount, arr[i]);
        }
        ans ^= computeOR(bitCount);

    
        for (int i = k; i < n; i++) {
            removeBits(bitCount, arr[i - k]);  
            addBits(bitCount, arr[i]);         
            ans ^= computeOR(bitCount);
        }

        System.out.println(ans);
    }

 
    static void addBits(int[] bitCount, int num) {
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                bitCount[i]++;
            }
        }
    }

  
    static void removeBits(int[] bitCount, int num) {
        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) != 0) {
                bitCount[i]--;
            }
        }
    }


    static int computeOR(int[] bitCount) {
        int orVal = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] > 0) {
                orVal |= (1 << i);
            }
        }
        return orVal;
    }
}
