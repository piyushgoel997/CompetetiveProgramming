import java.util.*;

/**
 * Created by piyus on 14-12-2017 at 21:36.
 */
public class RedKnightsShortestPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i_start = in.nextInt();
        int j_start = in.nextInt();
        int i_end = in.nextInt();
        int j_end = in.nextInt();
        printShortestPath(n, i_start, j_start, i_end, j_end);
        in.close();
    }

    private static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        if ((i_start - i_end) % 2 != 0 || Math.abs(Math.abs(j_start - j_end) - Math.abs((i_start - i_end) / 2)) % 2 != 0) {
            System.out.println("Impossible");
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (i_start > i_end) {
            i_start -= 2;
            if (j_start >= j_end && j_start > 0) {
                list.add(0);
                j_start--;
            } else {
                list.add(1);
                j_start++;
            }
        }



    }

//    private static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
//        if ((i_start - i_end) % 2 != 0 || Math.abs(Math.abs(j_start - j_end) - Math.abs((i_start - i_end) / 2)) % 2 != 0) {
//            System.out.println("Impossible");
//            return;
//        }
//
//        StringBuilder sp = new StringBuilder();
//        int count = 0;
//
//        while (i_start > i_end) {
//            i_start -= 2;
//            if (j_start >= j_end && j_start > 0) {
//                sp.append("UL ");
//                j_start--;
//            } else {
//                sp.append("UR ");
//                j_start++;
//            }
//            count++;
//        }
//
//
//        int k = j_end - Math.abs(i_end - i_start) / 2;
//
//        while (j_start < k) {
//            j_start += 2;
//            sp.append("R ");
//            count++;
//        }
//
//        while (i_start < i_end) {
//            i_start += 2;
//            if (j_start <= j_end && j_start < n - 1) {
//                sp.append("LR ");
//                j_start++;
//            } else {
//                sp.append("LL ");
//                j_start--;
//            }
//            count++;
//        }
//
//        while (j_start > j_end) {
//            sp.append("L ");
//            j_start -= 2;
//            count++;
//        }
//
//        System.out.println(count);
//        System.out.println(sp);
//
////        while (i_start != i_end || j_start != j_end) {
////            count++;
////            if (i_start == i_end && Math.abs(j_start - j_end) % 2 != 0) {
////                System.out.println("Impossible");
////                return;
////            }
////            if (i_start > i_end) {
////                if (j_start >= j_end) {
////                    sp.append("UL ");
////                    i_start -= 2;
////                    j_start -= 1;
////                } else {
////                    sp.append("UR ");
////                    i_start -= 2;
////                    j_start += 1;
////                }
////                continue;
////            }
////
////            if (i_start == i_end && j_start < j_end) {
////                sp.append("R ");
////                j_start += 2;
////                continue;
////            }
////
////            if (i_start < i_end) {
////                if (j_start <= j_end) {
////                    sp.append("LR ");
////                    i_start += 2;
////                    j_start += 1;
////                } else {
////                    sp.append("LL ");
////                    i_start += 2;
////                    j_start -= 1;
////                }
////                continue;
////            }
////            if (i_start == i_end && j_start > j_end) {
////                sp.append("L ");
////                j_start -= 2;
////            }
////        }
////        System.out.println(count);
////        System.out.println(sp);
//    }


}
