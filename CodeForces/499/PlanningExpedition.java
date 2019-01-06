import java.util.HashMap;
import java.util.Scanner;

public class PlanningExpedition {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = s.nextInt();
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        int days = 1;
        while (true){
            if (!possible(map, days, n)) {
                System.out.println(days - 1);
                return;
            }
            days++;
        }
    }

    private static boolean possible(HashMap<Integer, Integer> map, int days, int n) {
        int numPeople = 0;
        for (Integer i : map.values()) {
            numPeople += i / days;
            if (numPeople >= n) {
                return true;
            }
        }
        return false;
    }
}

