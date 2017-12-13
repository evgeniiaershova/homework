import javax.naming.OperationNotSupportedException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CollectionsTasks {

    public static void main(String[] args) throws Exception {

        task1();
        task2("'(', ')', '[', ']', '{', '}'");
        task3();
        task4(10);
        task4(100);
        task4(1000);
        task4(10000);
        task4(100000);
        task5(0);
    }

    private static void task1() throws Exception {
        File file = null;
        Scanner scanner = null;

        try {
            file = new File("C:\\Users\\Evgeniia_Ershova\\Documents\\Text_files\\text_for_collections.txt");
            scanner = new Scanner(file);
                if (!scanner.hasNext()) {
                    throw new Exception("File is empty!");
                }
        }
        catch (FileNotFoundException ex) {
            throw  new Exception("File \"text\" was not found", ex);
        }

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

    private static void task2(String initialString) {
        List<String> br = Arrays.asList(initialString.replaceAll("[', ]", "").split(""));
        Collections.reverse(br);

        Stack<String> stack = new Stack<String>();
        for (String bracket: br) {
            stack.push(bracket);
        }

        while (!stack.empty()) {
            String brOpen = stack.pop();
            String expected = "";
                switch (brOpen) {
                    case "(":
                            expected = ")";
                            checkBracket(stack, expected, brOpen);
                        break;
                    case "[":
                            expected = "]";
                            checkBracket(stack, expected, brOpen);
                        break;
                    case "{":
                            expected = "}";
                            checkBracket(stack, expected, brOpen);
                        break;
                    default:
                        throw new AssertionError("Character should be opening bracket, but was " + brOpen);
                }
            }
        }

    private static void checkBracket(Stack<String> stack, String expected, String brOpen) {
        if (!stack.empty()) {
           String brClose = stack.pop();
            if (!brClose.equals(expected)) {
                throw new AssertionError("Wrong bracket after " + brOpen +
                        ". Bracket should be " + expected + ", but was " + brClose);
            }
        } else {
            throw new AssertionError("There's opening bracket: " + brOpen
                    + ", but closing bracket is missing.");
        }
    }

    private static void task3() throws Exception {
      File file = null;
      Scanner scanner = null;

      try {
         file = new File("C:\\Users\\Evgeniia_Ershova\\Documents\\Text_files\\text_for_collections.txt");
         scanner = new Scanner(file);
         if (!scanner.hasNext()) {
             throw new Exception("File is empty!");
         }
         }
        catch (FileNotFoundException ex) {
          throw  new Exception("File \"text\" was not found", ex);
        }

        List<String> list = new ArrayList<String>();

        while (scanner.hasNext()) {
            list.add(scanner.next().toLowerCase().replaceAll("\\p{P}", ""));
        }

        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            set.add(word);
        }
    }

    private static long task4ArrayList(int nPeople) {

        long startTime = System.nanoTime();

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= nPeople; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % 2 == 0) {
                    list.remove(list.get(i));
                    i--;
                }
            }
            int listSize = list.size();
//            printCollection("After remove", list);

            list.clear();
            for (int j = 0, num = 1; j < listSize; j++) {
                list.add(num);
                num++;
            }
//            printCollection("After reinit", list);
        }
        long timeConsumed = System.nanoTime() - startTime;
        System.out.println("ArrayList time consumed: " + timeConsumed);
        return timeConsumed;
    }

    private static long task4LinkedList(int nPeople) {

        long startTime = System.nanoTime();

        List<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= nPeople; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % 2 == 0) {
                    list.remove(list.get(i));
                    i--;
                }
            }
            int listSize = list.size();
//            printCollection("After remove", list);

            list.clear();
            for (int j = 0, num = 1; j < listSize; j++) {
                list.add(num);
                num++;
            }
//            printCollection("After reinit", list);
        }
        long timeConsumed = System.nanoTime() - startTime;
        System.out.println("LinkedList time consumed: " + timeConsumed);
        return timeConsumed;
    }

    public static  void task4(int nPeople) {
       System.out.println("N = " + nPeople);
       long timeConsumedArray = task4ArrayList(nPeople);
       long timeConsumedLinked =  task4LinkedList(nPeople);
       long min = Math.min(timeConsumedArray, timeConsumedLinked);

       if (min == timeConsumedArray) {
           System.out.println("ArrayList is faster!");
       }
       if (min == timeConsumedLinked) {
           System.out.println("LinkedList is faster!");
       }
    }

    public static void task5(int number) {
        MyCustomClass myCustomClass = new MyCustomClass();
        myCustomClass.addInt(5);
        myCustomClass.addInt(7);
        myCustomClass.addInt(15);
        myCustomClass.addInt(100);
        myCustomClass.addInt(9);
        myCustomClass.addInt(-8);

        myCustomClass.findNearestInt(number);
    }

    public static class MyCustomClass {

        ArrayList<Integer> list;

        public MyCustomClass() {
            this.list = new ArrayList<Integer>();
        }

        private boolean addInt(int element) {
            return list.add(element);

        }

        private boolean removeInt(int element) {
            return list.remove(((Integer) element));
        }

        private void findNearestInt(int target) {
            int smallestDifference = Math.abs(list.get(0) - target);
            int nearestElement = list.get(0);
            List<Integer> result = new ArrayList<Integer>();
            result.add(nearestElement);
             for (int i = 1; i < list.size(); i++) {
                int dif = Math.abs(list.get(i) - target);
                if (dif < smallestDifference) {
                    smallestDifference = dif;
                    nearestElement = list.get(i);
                    result.clear();
                    result.add(nearestElement);
                }

                if ((dif == smallestDifference) && (nearestElement != list.get(i))) {
                    result.clear();
                    result.add(nearestElement);
                    result.add(list.get(i));
                }
            }
            printCollection("The nearest int: ", result);

        }
    }

    private static void task6() throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Task 6 ");
    }

    private static void printCollection(String comment, Collection collection) {
        System.out.println(comment);
        for (Object item : collection) {
            System.out.println(item);
        }
    }
 }