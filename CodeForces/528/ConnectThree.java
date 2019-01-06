import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ConnectThree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Coord[] vertices = new Coord[3];
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Coord();
            vertices[i].x = s.nextInt();
            vertices[i].y = s.nextInt();
            minX = Math.min(minX, vertices[i].x);
            minY = Math.min(minY, vertices[i].y);
            maxX = Math.max(maxX, vertices[i].x);
            maxY = Math.max(maxY, vertices[i].y);
        }
        Arrays.sort(vertices, Comparator.comparingInt(Coord::getX));
        int ct = 0;
        ct += maxX - minX;
        ct += maxY - minY + 1;
        System.out.println(ct);
        for (int i = minY; i <= maxY; i++) {
            System.out.println(vertices[1].x + " " + i);
        }
        for (int i = minX; i < vertices[1].x; i++) {
            System.out.println(i + " " + vertices[0].y);
        }
        for (int i = vertices[1].x + 1; i <= maxX; i++) {
            System.out.println(i + " " + vertices[2].y);
        }
    }

    static class Coord {
        int x;
        int y;

        public int getX() {
            return x;
        }
    }
}
