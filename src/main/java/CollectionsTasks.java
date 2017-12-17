import javax.naming.OperationNotSupportedException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CollectionsTasks {

    public static void main(String[] args) throws Exception {

        task1();
        task2("'}(', ')', '[', ']', '{', '}{[]}'");
        task3();
        task4(10);
        task4(100);
        task4(1000);
        task4(10000);
        task4(100000);
        task5(0);

        task6();

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

        Stack<String> closingBracketsStack = new Stack<String>();

        String bracket = br.get(0);

        if (!(bracket.equals("(") || bracket.equals("[") || bracket.equals("{"))) {
            throw new AssertionError("Wrong bracket, expected any opening bracket, but got: " + bracket);
        }

        for (int i = 0; i < br.size(); i++) {
            if (!(br.size() % 2 == 0)) {
                throw new AssertionError("Number of brackets is not even. So, the string is not correct.");
            } else {
                bracket = br.get(i);
                String brFromStack;
                switch (bracket) {
                    case "(":
                        closingBracketsStack.push(")");
                        break;
                    case ")":
                        checkBracket(closingBracketsStack, bracket, initialString);
                        break;
                    case "[":
                        closingBracketsStack.push("]");
                        break;
                    case "]":
                        checkBracket(closingBracketsStack, bracket, initialString);
                        break;
                    case "{":
                        closingBracketsStack.push("}");
                        break;
                    case "}":
                        checkBracket(closingBracketsStack, bracket, initialString);
                        break;
                }
            }
        }

        if (!closingBracketsStack.empty()) {
            System.out.println("======");
            while (!closingBracketsStack.empty()) {
                System.out.println(closingBracketsStack.pop());
            }
            throw new AssertionError("The stack should be empty, but it not. ");
        }
    }

    private static void checkBracket(Stack<String> closingBracketsStack, String bracket, String initialString) {
        if (!closingBracketsStack.empty()) {
            String brFromStack = closingBracketsStack.pop();
            if (!bracket.equals(brFromStack)) {
                throw new AssertionError("Wrong bracket, expected:" + brFromStack + ", but got: " + bracket);
            }
        } else throw new AssertionError("Closing bracket " + bracket + " is not expected here:  " + initialString);

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
        HashMap<Integer, double[]> listOfPoints = new HashMap<Integer, double[]>();
        listOfPoints.put(0, new double[]{7,-2});
        listOfPoints.put(1, new double[]{4,-4});
        listOfPoints.put(2, new double[]{8,11});
        listOfPoints.put(3, new double[]{5,4});
        listOfPoints.put(4, new double[]{-5,8});
        listOfPoints.put(5, new double[]{-2,5});
        listOfPoints.put(6, new double[]{-3,3});
        listOfPoints.put(7, new double[]{-4,-1});
        listOfPoints.put(8, new double[]{-2,-2});
        listOfPoints.put(9, new double[]{0,-3});
        listOfPoints.put(10, new double[]{-6,0});

        //для каждой точки взять каждую точку не включая саму точку
        // составить уравнение прямой
        // и еще раз пройти по каждой точке, не включая 2 текущие и проверить, есть ли еще точки, которые
        //удовлетворяют этому уравнению
        // если такие точки есть, вывести все точки (2 исходные и удовлетворяющие уравнению прямой)
        //(x - x1) / (x2 - x1) = (y - y1)/ (y2 - y1);

        //для каждой точки из списка
        for (int i = 0; i < listOfPoints.size(); i++) {
            double x1 = listOfPoints.get(i)[0];
            double y1 = listOfPoints.get(i)[1];
            // взять каждую точку
            for (int j = i + 1; j < listOfPoints.size() ; j++) {
                    double x2 = listOfPoints.get(j)[0];
                    double y2 = listOfPoints.get(j)[1];
                    Map<Integer, double[]> map = new HashMap<Integer, double[]>();
                    // и еще раз пройти по каждой точке, не включая 2 текущие
                    for (int n = 0; n < listOfPoints.size(); n ++ ) {
                        if ((n != i) && (n != j)) {
                            double x = listOfPoints.get(n)[0];
                            double y = listOfPoints.get(n)[1];
                            double left = (x - x1) / (x2 - x1);
                            double right = (y - y1)/ (y2 - y1);
                            // и проверить, удовлетворяют ли точки x и y уравнению прямой
                            if ((left == right) && (left != 0.0)){
                               map.put(n, new double[]{x, y});
                            }
                        }
                    }
                    if (map.size() > 0) {
                        System.out.println("For a line which crosses two points: ");
                        System.out.println("M" + i + "(" + x1 + "," + y1 + ")");
                        System.out.println("M" + j + "(" + x2 + "," + y2 + ")");
                        System.out.println("There are more points: ");
                        for (Map.Entry<Integer, double[]> en: map.entrySet()) {
                            System.out.println("M" + en.getKey() + " (" + en.getValue()[0] + "," + en.getValue()[1] + ")");
                        }
                    }
            }
        }
    }

//    8.	На плоскости задано N отрезков. Найти точку пересечения двух отрез¬ков, имеющую минимальную абсциссу.
// Использовать класс TreeMap.
    private static void task8() throws OperationNotSupportedException {
        Map<Integer, double[][]> listOfLines = new TreeMap<>();
        listOfLines.put(0, new double[][]{{-4, 1},{5, 7}});
        listOfLines.put(1, new double[][]{{-2,-7},{4, 1}});
        listOfLines.put(2, new double[][]{{5,7},{4, 1}});
        listOfLines.put(3, new double[][]{{-4,1},{-2, -7}});

        for (int i = 0; i < listOfLines.size(); i++) {

        }

        throw new OperationNotSupportedException("task 8 has not been implemented yet!");

        // составить пары линий каждой с каждой
        // найти точки пересечения: выбрать только те линии, у которых только одна точка пересечения
        // найти наименьшую x



    }

    private static void printCollection(String comment, Collection collection) {
        System.out.println(comment);
        for (Object item : collection) {
            System.out.println(item);
        }
    }

 }