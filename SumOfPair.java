public class SumOfPair {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 6, 7, 10, 9, 0, 1};

        int i, j;

        for (i = 0; i < 8; i++) {
            j = i + 1;
            while (j < 9) {
                if (arr[i] + arr[j] == 9) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
                j = j + 1;
            }
        }
    }
}
