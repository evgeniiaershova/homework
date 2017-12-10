import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.*;

public class CollectionsTasks {

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        File file = new File(CollectionsTasks.class.getClassLoader().getResource("text").toURI());

        task1(file);
        task2();
        task3(file);
    }


    //    Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке(Stack).
    private static void task1(File file) throws URISyntaxException, FileNotFoundException {

        Scanner scanner = new Scanner(file);
        Stack stack = new Stack();

        System.out.println("Direct order: ");
        System.out.println("==========================");

        while (scanner.hasNext()) {
            String word = scanner.next();
            stack.push(word);
            System.out.println(word);
        }

        System.out.println("==========================");
        System.out.println("Reversed order: ");
        System.out.println("==========================");
        while (!stack.empty()) {
            System.out.println(stack.pop().toString());
        }
    }


        /*    Задана строка, содержащая символы '(', ')', '[', ']', '{', '}'.
        Проверить правильность расстановки скобок. Использовать стек.*/

    private static void task2() {
        throw new UnsupportedOperationException("Task2 was not implemented yet!");
    }

        /*    Задан файл с текстом на английском языке.
        Выделить все различные слова. Слова,
        отличающиеся только регистром букв, считать одинаковыми.
         Использовать класс HashSet.*/

    private static void task3(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<String> list = new ArrayList<String>();

        while (scanner.hasNext()) {
            list.add(scanner.next().toLowerCase().replaceAll("\\p{P}", ""));
        }

        HashSet<String> set = new HashSet<String>();
        for (String word: list) {
          set.add(word);
        }
    }
}
