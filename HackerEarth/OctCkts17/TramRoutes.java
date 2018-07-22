package OctCkts17;

import java.util.*;

/**
 * Created by piyus on 24-10-2017 at 22:43.
 */
public class TramRoutes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int q = s.nextInt();

        Route[] routes = new Route[m];

        for (int i = 0; i < m; i++) {
            int id = i + 1;
            int cost = s.nextInt();
            Set<Integer> stations = new HashSet<>();
            int cnt = s.nextInt();
            for (int j = 0; j < cnt; j++) {
                stations.add(s.nextInt());
            }
            routes[i] = new Route(id, cost, stations);
        }
        Set<Integer> left = new HashSet<>();
        for (int i = 0; i < 2 * q; i++) left.add(s.nextInt());
        Arrays.sort(routes, Comparator.comparingInt(r -> r.cost));
        Set<Integer> chosenRoutes = new HashSet<>();
        for (Route r : routes) {
            //add only if it contains the stations in the left set
            if (left.removeAll(r.stations)) {
                chosenRoutes.add(r.id);
            }
        }
        // TODO IfAtFirst problem in a few cases is that the network isn't getting fully connected. Solve this using union find.
        System.out.println(chosenRoutes.size());
        for (Integer chosenRoute : chosenRoutes) {
            System.out.println(chosenRoute);
        }
    }

    static class Route {
        final int id;
        final int cost;
        final Set<Integer> stations;

        Route(int id, int cost, Set<Integer> stations) {
            this.id = id;
            this.cost = cost;
            this.stations = new HashSet<>(stations);
        }
    }

    public class UF {

        private int[] id;

        public UF(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
        }

        public void union(int x, int y) {
            int idy = id[y];
            for (int i = 0; i < id.length; i++) {
                if (id[i] == idy) {
                    id[i] = id[x];
                }
            }
        }

        public boolean connected(int x, int y) {
            return id[x] == id[y];
        }

    }
}
