import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m:
        while (true) {
            System.out.println("Выберете необходимый вариант \n " +
                                "1. A1 \n 2. B1 \n 3. B2 \n 4. B3 \n 5. C1 \n 0. Выход.");
            int sw = scanner.nextInt();
            switch (sw) {
                case 0:
                    break m;
                case 1:
                    MyClass.a1();
                    break;
                case 2:
                    MyClass.b1();
                    break;
                case 3:
                    MyClass.b2();
                    break;
                case 4:
                    MyClass.b3();
                    break;
                case 5:
                    MyClass.c1();
                    break;
                default:
                    System.out.println("Неверный формат");
                    break;
            }
        }
    }
}
