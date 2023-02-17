
/**
 Написать программу вычисления n-ого треугольного числа
 Натуральное число x является треугольным тогда и только тогда, 
 когда число 8x+1 является полным квадратом
 */
import java.util.Scanner;

public class Lesson1 {

    public static void main(String[] args) {
        int x = get_numb();
        int t = check_triangle(x);
        if (t > 1) {
            int n = (t - 1) / 2; // n = (sqrt(8x+1) - 1 )/2
            write_t(n);
        } else
            System.out.println("Число не является треугольным ");
    }

    public static int get_numb() {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите целое число: ");
        int x = iScanner.nextInt();
        iScanner.close();
        return x;
    }

    public static int check_triangle(int x) {
        int tr = 8 * x + 1;
        double sq = Math.sqrt(tr);
        if (tr % sq == 0) // проверка полного квадрата
            return ((int) sq);
        else
            return 0;
    }

    public static void write_t(int n) {
        String line = "T" + n + " = ";
        for (int i = 1; i < n + 1; i++) {
            if (i > 1)
                line = line + " + ";
            line = line + i;
        }
        System.out.println(line);
    }

}