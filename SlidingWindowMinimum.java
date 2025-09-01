import java.util.*;

class SlidingWindowMinimum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int n = sc.nextInt();  
        int k = sc.nextInt();  
        
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
        
        
        Deque<Integer> deque = new LinkedList<>();
        long xorResult = 0;
        
        for (int i = 0; i < n; i++) {
            
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            
      
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
                deque.pollLast();
            }
            
          
            deque.offerLast(i);
            
            
            if (i >= k - 1) {
                xorResult ^= arr[deque.peekFirst()];
            }
        }
        
        // Output
        System.out.println(xorResult);
        
        sc.close();
    }
}
