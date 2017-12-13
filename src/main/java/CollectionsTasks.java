import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CollectionsTasks {

    public static void main(String[] args) {

    for (int i = 0; i < 10; i ++){
        task4ArrayList();
        task4LinkedList();
        }


        MyCustomClass myCustomClass = new MyCustomClass();
        myCustomClass
                .addInt(5)
                .addInt(7)
                .addInt(15)
                .addInt(100)
                .addInt(9)
                .addInt(-8);
        System.out.println(Arrays.toString(myCustomClass.findNearestInt(8)));
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

    private static void task2() {
        throw new UnsupportedOperationException("Task2 was not implemented yet!");
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

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            set.add(word);
        }
    }

    private static void task4ArrayList() {

        int nPeople = 1000;
        long startTime = System.nanoTime();

        List<Integer> list = new ArrayList<>();
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
            printCollection("After reinit", list);
        }

        System.out.println("ArrayList time consumed: " + (System.nanoTime() - startTime));
    }

    private static void task4LinkedList() {

        int nPeople = 1000;
        long startTime = System.nanoTime();

        List<Integer> list = new LinkedList<>();
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
        System.out.println("LinkedList time consumed: " + (System.nanoTime() - startTime));
    }

    private static void printCollection(String comment, Collection collection) {
        System.out.println(comment);
        for (Object item : collection) {
            System.out.println(item);
        }
    }

    public static class MyCustomClass {

        ArrayList<Integer> list;

        public MyCustomClass() {
            this.list = new ArrayList<>();
        }

        private MyCustomClass addInt(int element) {
            list.add(element);
            return this;
        }

        private MyCustomClass removeInt(int element) {
            list.remove(((Integer) element));
            return this;
        }

        private int[] findNearestInt(int target) {
            Integer ie = target;
            int smallestDifference = Math.abs(list.get(0) - target);
            int nearestElement = list.get(0);
            int run = 0;
            int[] result = new int[2];
             for (int i = 1; i < list.size(); i++) {
                int dif = Math.abs(list.get(i) - target);
                if (dif < smallestDifference) {
                    smallestDifference = dif;
                    nearestElement = list.get(i);
                    result = new int[]{nearestElement};
                }

                if ((dif == smallestDifference) && (nearestElement != list.get(i))) {
                   result =  new int[]{nearestElement, list.get(i)};
                }
            }
            return result;

        }
    }

//    TODO: 2, 5
//    6

    }