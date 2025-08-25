import java.util.Scanner;
class TrailingZeros{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        int count = 0;
        for(int i=5; i<=n; i=i*5){
            count = count+n/i;
        }
        System.out.println("Number of trailing zeros in "+n+"! is: "+count);
    }
}