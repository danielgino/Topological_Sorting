package question2;

public class Question2 {
    public static void main(String[] args) {
        System.out.println("======== Section A ==========");
        for (int n = 0; n <= 10; n++) {
            System.out.println("T(" + n + ") = " + countEvenRed(n));
        }
        System.out.println("======== Section B ==========");
        for (int n = 0; n <= 10; n++) {
            System.out.println("T(" + n + ") = " + countEvenRedDP(n));
        }
        System.out.println("Total Cost Section B: O(N)");
    }
    public static int countEvenRed(int n) {
        if (n == 0) return 1;
        int even = countEvenRed(n - 1);
        int total = (int) Math.pow(3, n - 1);
        int odd = total - even;
        return 2 * even + odd;
    }
    public static int countEvenRedDP(int n) {
        int[] T = new int[n + 1];
        T[0] = 1;

        for (int i = 1; i <= n; i++) {
            T[i] = T[i - 1] + (int) Math.pow(3, i - 1);
        }

        return T[n];
    }
}
