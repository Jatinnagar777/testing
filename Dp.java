import java.util.*;

class Main {
    static boolean t[][];

    public static boolean subSet(int arr[], int sum, int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    t[i][j] = true;
                } else if (i == 0) {
                    t[i][j] = false;
                } else if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 8, 10};
        int sum = 11;
        int n = arr.length;
        t = new boolean[n + 1][sum + 1];

        boolean result = subSet(arr, sum, n);
        System.out.println(result);
    }
}
