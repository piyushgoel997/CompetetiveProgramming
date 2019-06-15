import java.util.Scanner;

public class LostNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] a = {42, 23, 16, 15, 8, 4};

        int[] q = new int[4];
        for (int i = 0; i < 4; i++) {
            System.out.println("? " + (i + 1) + " " + (i + 2));
            System.out.flush();
            q[i] = s.nextInt();
        }
        int[] ans = new int[6];
        for (int i = 0; i < 6; i++) {
            if (q[0] % a[i] == 0 && q[1] % a[i] == 0) {
                ans[1] = a[i];
                break;
            }
        }
        ans[0] = q[0] / ans[1];
        ans[2] = q[1] / ans[1];
        ans[3] = q[2] / ans[2];
        ans[4] = q[3] / ans[3];

        for (int i = 0; i < 6; i++) {
            boolean found = false;
            for (int j = 0; j < 5; j++) if (a[i] == ans[j]) found = true;
            if (!found) {
                ans[5] = a[i];
            }
        }

        System.out.print("! ");
        for (int i = 0; i < 6; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
