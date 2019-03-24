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
        s1 = s1.replace(s2,""); //Метод заменяет все совпадения с s2 на пустоту, то есть удаляет.
        System.out.println(s1);
    }


    static void b1(){
        System.out.println("Дан текст из слов, разделенных пробелами. " +
                "Вывести на экран все слова, совпадающие с последним словом фразы. " +
                "Если таких слов нет, выдать соответствующее сообщение.");
        System.out.println("Введите текст");
        String s = scanner.nextLine() + " ";
        String[] arr = s.split(" "); //Разделение строки на массив. Разделителем является пробел
        boolean f = false; //Переменная для уточнения, было ли совпадающее слово
        for (int i = 0; i < arr.length - 1; i++){       //Для всех слов кроме последнего
            if (arr[i].equals(arr[arr.length - 1])){    //Если слово совпадает
                f = true;                               //Выставить флаг
                System.out.print(arr[i] + " ");         //Вывести его на экран
            }
        }
        if (!f) System.out.println("В тексте нет слов, совпадающих с последним словом фразы"); //Если не совпадает вывести сообщение
        System.out.println();
    }


    static void b2(){
        System.out.println("После каждого слова текста, заканчивающегося " +
                "заданной подстрокой, вставить указанное слово.");
        System.out.println("Введите текст");
        String s = scanner.nextLine() + " ";
        String[] arr = s.trim().split(" "); //Разделение строки на массив. Разделителем является пробел. Trim убирает пробелы по краям, что бы не было лишних слов
        System.out.println("Введите подстроку, на которую должно заканчиваться слово");
        String sub = scanner.nextLine();
        System.out.println("Введите слово, которое необходимо вставить");
        String word = scanner.nextLine();
        for (int i = 0; i < arr.length; i++){
            if (arr[i].trim().contains(sub))                                            //Если в слове содержится подстрока
                    arr[i] = arr[i].replace(arr[i], arr[i] + " " + word);     //Заменить его на "текущее слово + необходимое вставить!
        }
        s = String.join(" ", arr); //Получить одну строку из массива строк
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
        int k = s.indexOf(c1) - s.lastIndexOf(c2); //первое включение начального символа и последнее включение конечного символа это и есть максимальное расстояние
        if (s.contains(Character.toString(c1)) && s.contains(Character.toString(c2)) && k < 0) //Если в тексте присутствуют данные символы в необходимом порядке
            s = s.replace(s.substring(s.indexOf(c1), s.lastIndexOf(c2) + 1), ""); //Удалить содержимое
        System.out.println(s);
    }


    static void c1(){
        System.out.println("Имеется внешний текстовый файл Book. " +
                "Написать программу, которая, игнорируя исходное деление этого файла на строки, переформатирует его, " +
                "разбивая на строки так, чтобы каждая строка оканчивалась точкой либо содержала ровно 60 литер, " +
                "если среди них нет точки.");

        StringBuilder s = new StringBuilder();  //переменная для считывания и записи
        try(FileReader reader = new FileReader("./Book/Book.txt")) //связывание reader с файлом
            {
                int c; //переменная, в которую будет записан очередной символ
                while((c = reader.read())!= -1){ //пока не конец файла
                    if (c != 13 && c != 10) //если это не переход на новую строку
                        s.append((char)c); //записать этот символ в строку s
                }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        try(FileWriter writer = new FileWriter("./Book/Book.txt", false))
        {
            int k = 1; //счёьчик литералов
            for (int i = 0; i < s.length(); i++) {
                if (s.toString().charAt(i) == '.') {                    // если очередной символ строки s точка
                    writer.append(s.toString().charAt(i)).append('\n'); //записать её в файл и перейти на новую строку
                    k = 0;                                              //Обнулить счётчик, так как осуществлён переход на новую строку
                }
                else if (k == 60) {         //Если в строке уже 60 символов
                    writer.append('\n');    //Перейти на новую строку
                    k = 0;                  //Обнулить счётчик
                }
                else  {
                    writer.append(s.toString().charAt(i)); //Если ничего из вышеперечисленного, то просто записать символ в файл
                    k++;                                   //и увеличить счётчик
                }
            }
            writer.flush();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}