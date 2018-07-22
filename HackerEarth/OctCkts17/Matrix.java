package OctCkts17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by piyus on 24-10-2017 at 23:00.
 * TODO Think of a more efficient solution.
 */
public class Matrix {

    private static long[][] tallestBuilding;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        CoOrdinates[] buildings = new CoOrdinates[n];
        CoOrdinates[] start = new CoOrdinates[q];
        CoOrdinates[] finish = new CoOrdinates[q];
        for (int i = 0; i < n; i++) {
            buildings[i] = new CoOrdinates(s.nextLong(), s.nextLong());
        }
        for (int i = 0; i < q; i++) {
            long sx = s.nextLong();
            long sy = s.nextLong();
            long fx = s.nextLong();
            long fy = s.nextLong();
            if (sx < fx) {
                start[i] = new CoOrdinates(sx, sy);
                finish[i] = new CoOrdinates(fx, fy);
            } else {
                start[i] = new CoOrdinates(fx, fy);
                finish[i] = new CoOrdinates(sx, sy);
            }
        }
        Arrays.sort(buildings, Comparator.comparingLong(b -> b.x));
        tallestBuilding = new long[n + 1][n + 1];
//        dp(buildings);
        for (int i = 0; i < q; i++) {
            System.out.println(findTime(start[i], finish[i], buildings));
        }
    }

//    private static long findTime(CoOrdinates start, CoOrdinates finish, CoOrdinates[] buildings) {
//        long maxHtFound = Long.MIN_VALUE;
//        long minHtRqd = Math.max(start.y, finish.y);
//        for (CoOrdinates building : buildings) {
//            if (building.y < minHtRqd) break;
//            if (building.x > start.x && building.x < finish.x) {
//                maxHtFound = building.y;
//                break;
//            }
//        }
//        long time = finish.x - start.x;
//        if (maxHtFound != Long.MIN_VALUE) {
//            maxHtFound++;
//            time += maxHtFound - start.y;
//            time += maxHtFound - finish.y;
//        } else {
//            time += Math.abs(finish.y - start.y);
//        }
//        return time;
//    }

    private static long findTime(CoOrdinates start, CoOrdinates finish, CoOrdinates[] buildings) {
        long maxHtFound = Long.MIN_VALUE;
        long minHtRqd = Math.max(start.y, finish.y);
        int leftMost = -1;
        int rightMost = -1;
        for (CoOrdinates building : buildings) {
            if (building.x > start.x && building.x < finish.x) {
                if (building.y >= minHtRqd && building.y > maxHtFound)
                    maxHtFound = building.y;
            }
        }
        long time = finish.x - start.x;
        if (maxHtFound != Long.MIN_VALUE) {
            maxHtFound++;
            time += maxHtFound - start.y;
            time += maxHtFound - finish.y;
        } else {
            time += Math.abs(finish.y - start.y);
        }
        return time;
    }

//    private static long findTime(CoOrdinates start, CoOrdinates finish, CoOrdinates[] buildings) {
//        int i = binarySearch(buildings, start.x);
//        int j = binarySearch(buildings, finish.x);
//        if (i < 0) i = -i - 1;
//        if (j < 0) j = -j - 1;
////        System.out.println(i + "," + j);
//        long maxHtFound = tallestBuilding[i][j];
//        long minHtRqd = Math.max(start.y, finish.y);
////        System.out.println(maxHtFound);
//        if (maxHtFound >= minHtRqd) {
//            return Math.abs(finish.x - start.x) + Math.abs(maxHtFound + 1 - start.y) + Math.abs(maxHtFound + 1 - finish.y);
//        } else {
//            return Math.abs(finish.x - start.x) + Math.abs(finish.y - start.y);
//        }
//    }
//
//    private static void dp(CoOrdinates[] buildings) {
//        for (int i = 0; i < buildings.length; i++) {
//            long maxHt = 0;
//            for (int j = 0; j < i + 1; j++) {
//                tallestBuilding[i][j] = Long.MIN_VALUE;
//            }
//            for (int j = i + 1; j < buildings.length + 1; j++) {
//                if (buildings[j - 1].y > maxHt) {
//                    0maxHt = buildings[j - 1].y;
//                }
//                tallestBuilding[i][j] = maxHt;
//            }
//        }
//    }
//
//    static long[][] tallestBuilding;


/*
2 3
1 1
3 4
0 1 2 1
0 1 4 4
-1 -1 -1 -1
*/

    private static class CoOrdinates {
        long x;
        long y;

        CoOrdinates(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    //    private static long findTime(CoOrdinates start, CoOrdinates finish, CoOrdinates[] buildings) {
//        long minHtRqd = Math.max(start.y, finish.y);
//        long maxHtFound = minHtRqd - 1;
//        for (int i = buildings.length - 1; i >= 0; i--) {
//            if (buildings[i].y < minHtRqd) break;
//            if (buildings[i].x < finish.x && buildings[i].x > start.x) {
//                maxHtFound = buildings[i].y;
//                break;
//            }
//        }
//        if (maxHtFound >= minHtRqd) {
//            return Math.abs(finish.x - start.x) + Math.abs(maxHtFound + 1 - start.y) + Math.abs(maxHtFound + 1 - finish.y);
//        } else {
//            return Math.abs(finish.x - start.x) + Math.abs(finish.y - start.y);
//        }
//    }

    private static int binarySearch(CoOrdinates[] a, long key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid].x;

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }





/*  public static void main(String[] args) {

//        int[] arr = {1,2,3,4,6,7,8};
//        System.out.println(Arrays.binarySearch(arr,5));


        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();
        Building[] buildings = new Building[n];
        long[] sx = new long[q];
        long[] sy = new long[q];
        long[] fx = new long[q];
        long[] fy = new long[q];

        for (int i = 0; i < n; i++) {
            buildings[i] = new Building();
            buildings[i].x = s.nextLong() + 1_000_000_000;
            buildings[i].y = s.nextLong() + 1_000_000_000;
        }
        for (int i = 0; i < q; i++) {
            sx[i] = s.nextLong() + 1_000_000_000;
            sy[i] = s.nextLong() + 1_000_000_000;
            fx[i] = s.nextLong() + 1_000_000_000;
            fy[i] = s.nextLong() + 1_000_000_000;
        }
        Arrays.sort(buildings, Comparator.comparingLong(a -> a.x));
        height = new long[buildings.length + 1][buildings.length + 1];
        for (int i = 0; i < q; i++) {
            if (fx[i] > sx[i])
                System.out.println(findTime(buildings, sx[i], sy[i], fx[i], fy[i]));
            else
                System.out.println(findTime(buildings, fx[i], fy[i], sx[i], sy[i]));
        }
    }

    static class Building {
        long x;
        long y;
    }

*//*
2 3
1 1
3 4
0 1 2 1
0 1 4 4
-1 -1 -1 -1
*//*

    private static long[][] height;

    private static long findTime(Building[] buildings, final long sx, final long sy, final long fx, final long fy) {
        long time = 0;
        long maxHt = 0;
        long minHtRqd = Math.max(sy, fy);
        int bs = binarySearch(buildings, sx);
        if (bs < 0) bs = -bs - 1;
        int fbs = binarySearch(buildings, fx);
        if (fbs < 0) fbs = -fbs - 1;
//        if (fbs > 0) fbs--;
        if (height[bs][fbs] == 0) {
            for (int i = bs; i < buildings.length; i++) {
                Building building = buildings[i];
                if (building.x <= sx) continue;
                if (building.x >= fx) break;
                if (building.y > maxHt) maxHt = building.y;
                height[bs][i] = maxHt;
            }
            height[bs][fbs] = maxHt;
        } else {
            maxHt = height[bs][fbs];
        }
        if (maxHt < minHtRqd) maxHt = 0;
        if (maxHt != 0) {
            maxHt++;
            time += maxHt - sy;
            time += maxHt - fy;
        } else {
//            System.out.println("X");
            time += Math.abs(fy - sy);
        }
        time += Math.abs(fx - sx);
        return time;
    }

//    private static long findTime(Building[] buildings, int cx, int cy, int fx, int fy) {
//        long time = 0;
//        if (fx < cx) {
//            int temp = cx;
//            cx = fx;
//            fx = temp;
//            temp = cy;
//            cy = fy;
//            fy = temp;
//        }
//        int idx = binarySearch(buildings, cx);
//        if (idx < 0) {
//            idx = -idx - 2;
//            if (idx < 0) idx = 0;
//        }
//        for (int i = idx; i < buildings.length; i++) {
//            Building building = buildings[i];
//            if (building.x < cx) continue;
//            if (building.x >= fx) break;
//            time += Math.abs(building.x - cx);
//            cx = building.x;
//            if (cy <= building.y) {
//                time += Math.abs(building.y - cy) + 1;
//                cy = building.y + 1;
//            }
//        }
//        time += Math.abs(fx - cx);
//        time += Math.abs(fy - cy);
//        return time;
//    }
//
    private static int binarySearch(Building[] a, long key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid].x;

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
*/
}
