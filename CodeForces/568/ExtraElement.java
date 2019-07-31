import java.util.*;

public class ExtraElement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long[] arr = new long[n];
        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Arrays.sort(arr);
        if (n <= 3) {
            System.out.println(1);
            return;
        }

        int index = -2;
        long cd = 0;
        if (arr[1] - arr[0] != arr[2] - arr[1]) {
            if (arr[2] - arr[0] == arr[3] - arr[2]) {
                index = 1;
                cd = arr[2] - arr[0];
            } else if (arr[3] - arr[2] == arr[2] - arr[1]) {
                index = 0;
                cd = arr[3] - arr[2];
            } else {
                System.out.println(index + 1);
                return;
            }
        }

        for (int i = 1; i < n - 2; i++) {
            if (arr[i + 1] - arr[i] != cd) {
                if (arr[i + 2] - arr[i] == cd) {
                    if (index == -2) index = i + 1;
                    else {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        int i = n - 3;




//        long[] diff = new long[n - 1];
//        HashMap<Long, Integer> diffMap = new HashMap<>();
//        for (int i = 0; i < n - 1; i++) {
//            diff[i] = arr[i + 1] - arr[i];
//            diffMap.putIfAbsent(diff[i], 0);
//            diffMap.put(diff[i], diffMap.get(diff[i]) + 1);
//        }
//        if (diffMap.size() > 3) {
//            System.out.println(-1);
//            return;
//        }
//        ArrayList<Long> dList = new ArrayList<>(diffMap.keySet());
//        if (dList.size() == 1) {
//            System.out.println(1);
//            return;
//        }
//
//        if (dList.size() == 2) {
//            Collections.sort(dList);
//            if (dList.get(0) * 2 == dList.get(1)) {
//                if (diffMap.get(dList.get(0)) == 2) {
//                    for (int i = 0; i < diff.length - 1; i++) {
//                        if (diff[i] == dList.get(0)) {
//                            if (diff[i + 1] == diff[i]) {
//                                System.out.println(map.get(arr[i + 1]).get(0) + 1);
//                                return;
//                            }
//                        }
//                    }
//                }
//            }
//            if (diffMap.get(dList.get(0)) == 1) {
//                if (diff[n - 2] == dList.get(0)) {
//                    System.out.println(map.get(arr[n - 1]).get(0) + 1);
//                    return;
//                }
//                if (diff[0] == dList.get(0)) {
//                    System.out.println(map.get(arr[0]).get(0) + 1);
//                    return;
//                }
//            }
//            if (diffMap.get(dList.get(1)) == 1) {
//                if (diff[n - 2] == dList.get(1)) {
//                    System.out.println(map.get(arr[n - 1]).get(0) + 1);
//                    return;
//                }
//                if (diff[0] == dList.get(1)) {
//                    System.out.println(map.get(arr[0]).get(0) + 1);
//                    return;
//                }
//            }
//        }
//        if (dList.size() == 3) {
//            Collections.sort(dList);
//            if (dList.get(0) + dList.get(1) == dList.get(2)) {
//                if (diffMap.get(dList.get(0)) == 1 && diffMap.get(dList.get(1)) == 1) {
//                    for (int i = 0; i < diff.length - 1; i++) {
//                        if (diff[i] == dList.get(0) || diff[i] == dList.get(1)) {
//                            if (diff[i + 1] == dList.get(0) || diff[i + 1] == dList.get(1)) {
//                                System.out.println(map.get(arr[i + 1]).get(0) + 1);
//                                return;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(-1);
    }
}
