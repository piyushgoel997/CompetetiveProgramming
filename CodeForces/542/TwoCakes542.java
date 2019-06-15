import java.util.HashMap;
import java.util.Scanner;

public class TwoCakes542 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[2 * n];
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
            if (!map.containsKey(arr[i])) {
                Integer[] temp = new Integer[2];
                temp[0] = i;
                map.put(arr[i], temp);
            } else {
                map.get(arr[i])[1] = i;
            }
        }
        Integer[] temp = map.get(1);
        System.out.println(temp[0] + temp[1] + minDist(temp[0], temp[1], map, arr, n));
    }

    private static long minDist(Integer s, Integer d, HashMap<Integer, Integer[]> map, int[] arr, int n) {
        if (arr[s] == n) {
            return 0;
        }
        Integer[] temp = map.get(arr[s] + 1);
        long p1 = Math.abs(s - temp[0]) + Math.abs(d - temp[1]);
        long p2 = Math.abs(d - temp[0]) + Math.abs(s - temp[1]);
        if (p1 < p2) {
            return p1 + minDist(temp[0], temp[1], map, arr, n);
        } else {
            return p2 + minDist(temp[1], temp[0], map, arr, n);
        }
    }


}
