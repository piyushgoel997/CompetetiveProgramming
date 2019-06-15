import java.util.Scanner;

public class NNandOpticalIllusion {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double n = s.nextDouble();
        double r = s.nextDouble();
        double x = Math.sin(Math.PI / n);
        System.out.println(r * (x / (1 - x)));
    }
}
