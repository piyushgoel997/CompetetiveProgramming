import java.util.*;

public class Paragliding {
    static Scanner s;
    public static void main(String[] args) {
        s = new Scanner(System.in);
        int T = s.nextInt();
        for (int t = 0; t < T; t++) {
            int n = s.nextInt();
            int k = s.nextInt();

            long[] P = makeArray(n);
            long[] H = makeArray(n);

            long[] X = makeArray(k);
            long[] Y = makeArray(k);

            Coord[] poles = new Coord[n];
            for (int i = 0; i < n; i++) {
                poles[i] = new Coord(P[i], H[i]);
            }

            Coord[] balloons = new Coord[k];
            for (int i = 0; i < k; i++) {
                balloons[i] = new Coord(X[i], Y[i]);
            }

            Arrays.sort(poles, Comparator.comparingLong(Coord::getX));
            Arrays.sort(balloons, Comparator.comparingLong(Coord::getX));

            for (int i = 0; i < n; i++) {
                P[i] = poles[i].x;
                H[i] = poles[i].y;
            }

            for (int i = 0; i < k; i++) {
                X[i] = balloons[i].x;
                Y[i] = balloons[i].y;
            }

            HashSet<Integer> catched = new HashSet<>();

            for (int i = 0; i < n; i++) {
                long maxX = P[i] + H[i];
                long minX = P[i] - H[i];
//                int min = Arrays.binarySearch(P, minX);
//                int max = Arrays.binarySearch(P, maxX);
//                if (min < 0) min = -min - 1;
//                if (max < 0) max = -max - 1;
//                for (int j = min; j < n && j <= max; j++) {
//                    if (j == i) continue;
//                    if (H[j] >= H[i] - Math.abs(P[i] - P[j])) {
//                        if (P[j] < P[i]) {
//                            minX = Math.max(P[j], minX);  // +1
//                        } else {
//                            maxX = Math.min(P[j], maxX);  // -1
//                            break;
//                        }
//                    }
//                }

                int min = Arrays.binarySearch(X, minX);
                int max = Arrays.binarySearch(X, maxX);
                if (min < 0) min = -min - 1;
                if (max < 0) max = -max - 1;

                for (int j = min; j < k && j <= max; j++) {
                    if (!catched.contains(j) && Y[j] <= H[i] - Math.abs(P[i] - X[j])) {
                        catched.add(j);
                    }
                }
            }
            System.out.println("Case #" + (t + 1) + ": " + catched.size());
        }
    }

    private static class Coord {
        long x;
        long y;

        Coord(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getX() {
            return x;
        }
    }


    private static long[] makeArray(int n) {
        long x1 = s.nextLong();
        long x2 = s.nextLong();
        long a = s.nextLong();
        long b = s.nextLong();
        long c = s.nextLong();
        long m = s.nextLong();

        long[] arr = new long[n];
        arr[0] = x1;
        arr[1] = x2;
        for (int i = 2; i < n; i++) {
            arr[i] = ((a * arr[i - 1]) % m + (b * arr[i - 2]) % m + c) % m;
            arr[i] += 1;
        }
        return arr;
    }
}
