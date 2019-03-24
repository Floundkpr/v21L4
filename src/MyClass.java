import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

class MyClass {
    private static Scanner scanner = new Scanner(System.in);

    static void a1(){
        System.out.println("Даны две строки: S1 и S2. " +
                "Удалить из строки S1 все подстроки, совпадающие с S2. " +
                "Если таких подстрок нет, то вывести S1 без изменений.");
        System.out.println("Введите первую строку");
        String s1 = scanner.nextLine();
        System.out.println("Введите вторую строку");
        String s2 = scanner.nextLine();
        s1 = s1.replace(s2,"");
        System.out.println(s1);
    }


    static void b1(){
        System.out.println("Дан текст из слов, разделенных пробелами. " +
                "Вывести на экран все слова, совпадающие с последним словом фразы. " +
                "Если таких слов нет, выдать соответствующее сообщение.");
        System.out.println("Введите текст");
        String s = scanner.nextLine() + " ";
        String[] arr = s.split(" ");
        boolean f = false;
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i].equals(arr[arr.length - 1])){
                f = true;
                System.out.print(arr[i] + " ");
            }
        }
        if (!f) System.out.println("В тексте нет слов, совпадающих с последним словом фразы");
        System.out.println();
    }


    static void b2(){
        System.out.println("После каждого слова текста, заканчивающегося " +
                "заданной подстрокой, вставить указанное слово.");
        System.out.println("Введите текст");
        String s = scanner.nextLine() + " ";
        String[] arr = s.trim().split(" ");
        System.out.println("Введите подстроку, на которую должно заканчиваться слово");
        String sub = scanner.nextLine();
        System.out.println("Введите слово, которое необходимо вставить");
        String word = scanner.nextLine();
        for (int i = 0; i < arr.length; i++){
            if (arr[i].trim().contains(sub)) arr[i] = arr[i].replace(arr[i], arr[i] + " " + word);
        }
        s = String.join(" ", arr);
        System.out.println(s);
    }


    static void b3() {
        System.out.println("В тексте исключить подстроку максимальной длины, " +
                "начинающуюся и заканчивающуюся заданными символами.");
        System.out.println("Введите текст");
        String s = scanner.nextLine();
        System.out.println("Введите символ начала подстроки");
        char c1 = scanner.nextLine().charAt(0);
        System.out.println("Введите символ конца подстроки");
        char c2 = scanner.nextLine().charAt(0);
        int k = s.indexOf(c1) - s.lastIndexOf(c2);
        if (s.contains(Character.toString(c1)) && s.contains(Character.toString(c2)) && k < 0)
            s = s.replace(s.substring(s.indexOf(c1), s.lastIndexOf(c2) + 1), "");
        System.out.println(s);
    }


    static void c1(){
        System.out.println("Имеется внешний текстовый файл Book. " +
                "Написать программу, которая, игнорируя исходное деление этого файла на строки, переформатирует его, " +
                "разбивая на строки так, чтобы каждая строка оканчивалась точкой либо содержала ровно 60 литер, " +
                "если среди них нет точки.");

        StringBuilder s = new StringBuilder();
        try(FileReader reader = new FileReader("./Book/Book.txt"))
            {
                int c;
                while((c = reader.read())!= -1){
                    if (c != 13 && c != 10)
                        s.append((char)c);
                }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        try(FileWriter writer = new FileWriter("./Book/Book.txt", false))
        {
            int k = 1;
            for (int i = 0; i < s.length(); i++) {
                if (s.toString().charAt(i) == '.') {
                    writer.append(s.toString().charAt(i)).append('\n');
                    k = 0;
                }
                else if (k == 60) {
                    writer.append('\n');
                    k = 0;
                }
                else  {
                    writer.append(s.toString().charAt(i));
                    k++;
                }
            }
            writer.flush();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}