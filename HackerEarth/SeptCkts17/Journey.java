package SeptCkts17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by piyus on 02-10-2017 at 18:32.
 */
public class Journey {

    private static HashMap<Long, Long>[] moneyRqd;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] l = new int[n - 1];
        int[] c = new int[n - 1];
        int[] p = new int[n - 1];
        long maxChargeRqd = 0;
        for (int i = 0; i < n - 1; i++) {
            l[i] = s.nextInt();
            maxChargeRqd += l[i];
        }
        for (int i = 0; i < n - 1; i++) c[i] = s.nextInt();
        for (int i = 0; i < n - 1; i++) p[i] = s.nextInt();
        long minChargeRqd = 0;

        long[] ic = new long[m];
        for (int i = 0; i < m; i++) ic[i] = s.nextInt();
        Arrays.sort(ic);

        int i;
        for (i = 0; i < m; i++) {
            if (ic[i] >= maxChargeRqd) break;
            moneyRqd = new HashMap[n];
            for (int j = 0; j < n; j++) moneyRqd[j] = new HashMap<>();
            long ans = moneyRequired(0, l, c, p, ic[i]);
            if (ans == 0) {
                System.out.println(0);
                break;
            }
            System.out.println(ans);
        }
        while (i < m) {
            System.out.println(0);
            i++;
        }


        /*for (int i = 0; i < m; i++) {
            long initialCharge = s.nextLong();
            if (initialCharge >= maxChargeRqd) System.out.println(0);
            else if (initialCharge <= minChargeRqd) System.out.println(-1);
            else {
                moneyRqd = new HashMap[n];
                for (int j = 0; j < n; j++) moneyRqd[j] = new HashMap<>();
                long ans = moneyRequired(0, l, c, p, initialCharge);
                if (ans == 0) maxChargeRqd = ans;
                if (ans == -1) minChargeRqd = ans;
                System.out.println(ans);
            }
        }*/
    }

    /*private static long moneyRequired(final int currCity, final int[] l, final int[] c, final int[] p, final long batteryLeft) {
        if (currCity >= l.length) {
            if (batteryLeft >= 0) return 0;
            else return -1;
        }
        if (batteryLeft - l[currCity] < 0 && c[currCity] - l[currCity] < 0) return -1;
        else if (batteryLeft - l[currCity] < 0) return moneyRequired(currCity + 1, l, c, p, c[currCity] - l[currCity]) + p[currCity];
        else if (c[currCity] - l[currCity] < 0) return moneyRequired(currCity + 1, l, c, p, batteryLeft - l[currCity]);
        else return Math.min(moneyRequired(currCity + 1, l, c, p, batteryLeft - l[currCity]),
                    moneyRequired(currCity + 1, l, c, p, c[currCity] - l[currCity]) + p[currCity]);
    }*/

    private static long moneyRequired(final int currCity, final int[] l, final int[] c, final int[] p, final long batteryLeft) {
        if (currCity >= l.length) {
            if (batteryLeft >= 0) return 0;
            else return -1;
        }
        if (moneyRqd[currCity].containsKey(batteryLeft)) return moneyRqd[currCity].get(batteryLeft);
        if (batteryLeft - l[currCity] < 0 && c[currCity] - l[currCity] < 0) {
            moneyRqd[currCity].put(batteryLeft, (long) -1);
            return moneyRqd[currCity].get(batteryLeft);
        } else if (batteryLeft - l[currCity] < 0) {
            moneyRqd[currCity].put(batteryLeft, moneyRequired(currCity + 1, l, c, p, c[currCity] - l[currCity]) + p[currCity]);
            return moneyRqd[currCity].get(batteryLeft);
        } else if (c[currCity] - l[currCity] < 0) {
            moneyRqd[currCity].put(batteryLeft, moneyRequired(currCity + 1, l, c, p, batteryLeft - l[currCity]));
            return moneyRqd[currCity].get(batteryLeft);
        }
        else {
            moneyRqd[currCity].put(batteryLeft, Math.min(moneyRequired(currCity + 1, l, c, p, batteryLeft - l[currCity]),
                    moneyRequired(currCity + 1, l, c, p, c[currCity] - l[currCity]) + p[currCity]));
            return moneyRqd[currCity].get(batteryLeft);
        }
    }
}
