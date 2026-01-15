import java.util.Arrays;

public class Day15_Candy {

      public  static int minCandy(int arr[]) {
        int n = arr.length;
        int[] candy = new int[n];

        // Step 1: Initialize all with 1 candy
        Arrays.fill(candy, 1);

        // Step 2: Left → Right
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        // Step 3: Right → Left and sum
        int ans = candy[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
            ans += candy[i];
        }

        return ans;
    }
    public static void main(String[] args) {
        Day15_Candy solution = new Day15_Candy();
        int[] ratings = {1, 0, 2};
        int result = solution.minCandy(ratings);
        System.out.println("Minimum candies needed: " + result); // Output: 5
    }
}
