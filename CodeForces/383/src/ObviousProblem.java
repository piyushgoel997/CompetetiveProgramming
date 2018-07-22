import java.util.Scanner;

/**
 * Created by Piyush on 06-12-2016.
 */
public class ObviousProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            int temp = s.nextInt();
            arr[i] = Integer.toBinaryString(temp);
        }
        int ans = 0;
        String binaryX = Integer.toBinaryString(x);
        for (int i = 0; i < n; i++) {
            String first = arr[i];
            for (int j = i+1; j < n; j++) {
                String second = arr[j];
                if (checkXOR(first, second, binaryX)) {
                    ans += 1;
                }
            }
        }
        System.out.print(ans);
    }

    private static boolean checkXOR(String first, String second, String binaryX) {
        int smallerLen = first.length() < second.length() ? first.length() : second.length();
        int i = 1;
        String str = "";
        while (smallerLen - i >= 0) {
            char a = second.charAt(second.length() - i);
            char b = first.charAt(first.length() - i);
            if (a == b) {
                str = "0" + str;
            } else {
                str = "1" + str;
            }
            i++;
        }
        if (first.length() > second.length()) {
            str = first.substring(0, first.length() - i + 1) + str;
        }
        if (second.length() > first.length()) {
            str = second.substring(0, second.length() - i + 1) + str;
        }
        while (str.charAt(0) == '0') {
            if (str.length() <= 1) {
                break;
            }
            str = str.substring(1);
        }
        if (str.equals(binaryX)) {
            return true;
        }
        return false;
    }

}
