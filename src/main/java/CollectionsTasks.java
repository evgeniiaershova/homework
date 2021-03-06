import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class CollectionsTasks {

    public static void main(String[] args) throws Exception {
      /*  task1();
        task2("'}(', ')', '[', ']', '{', '}{[]}'");
        task3();
        task4(10);
        task5(0);
        task6();
        task7();
        task8();*/
        task10();
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

            list.clear();
            for (int j = 0, num = 1; j < listSize; j++) {
                list.add(num);
                num++;
            }
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
            list.clear();
            for (int j = 0, num = 1; j < listSize; j++) {
                list.add(num);
                num++;
            }
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
        class MyCustomClass {

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
                        result.add(list.get(i));
                    }
                }
                printCollection("The nearest int: ", result);
            }
        }

        MyCustomClass myCustomClass = new MyCustomClass();
        myCustomClass.addInt(5);
        myCustomClass.addInt(7);
        myCustomClass.addInt(15);
        myCustomClass.addInt(100);
        myCustomClass.addInt(9);
        myCustomClass.addInt(-8);
        myCustomClass.findNearestInt(number);

    }



    private static void task6() {
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

        HashSet<ArrayList<Integer>> set = new HashSet<>() ;
          //для каждой точки из списка
        for (int i = 0; i < listOfPoints.size(); i++) {
            double x1 = listOfPoints.get(i)[0];
            double y1 = listOfPoints.get(i)[1];
            // взять каждую точку
            for (int j = i + 1; j < listOfPoints.size() ; j++) {
                    double x2 = listOfPoints.get(j)[0];
                    double y2 = listOfPoints.get(j)[1];
                    ArrayList<Integer> poolOfDots = new ArrayList<>();
                    // и еще раз пройти по каждой точке, не включая 2 текущие
                    for (int n = 0; n < listOfPoints.size(); n ++ ) {
                        if ((n != i) && (n != j)) {
                            double x = listOfPoints.get(n)[0];
                            double y = listOfPoints.get(n)[1];
                            double left = (x - x1) / (x2 - x1);
                            double right = (y - y1)/ (y2 - y1);
                            // и проверить, удовлетворяют ли точки x и y уравнению прямой
                            if ((left == right) && (left != 0.0)){
                               poolOfDots.add(n);
                            }
                        }
                    }
                    if (!poolOfDots.isEmpty()) {
                        poolOfDots.add(i);
                        poolOfDots.add(j);
                        Collections.sort(poolOfDots);
                        set.add(poolOfDots);
                    }
            }
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("The following dots lay on one line: ");
            ArrayList<Integer> arrayList = (ArrayList<Integer>) iterator.next();
            for (Integer integer: arrayList) {
                System.out.println(integer + " (" + listOfPoints.get(integer)[0] + ", " + listOfPoints.get(integer)[1] + ")");
            }
        }
    }

    private static void task8() {
        Map<Integer, double[][]> listOfLines = new HashMap<>();
        listOfLines.put(0, new double[][]{{5.0, -2.0}, {1.0, -4.0}});
        listOfLines.put(1, new double[][]{{5.0, -4.0}, {1.0, -6.0}});
        listOfLines.put(2, new double[][]{{2.0, 1.0}, {2.0, -4.0}});
        listOfLines.put(3, new double[][]{{-4.0, 1.0}, {-2.0, -7.0}});
        listOfLines.put(4, new double[][]{{4.0, -3.0}, {2.0, -7.0}});
        listOfLines.put(5, new double[][]{{1.0, -5.0}, {1.0, -8.0}});

        TreeMap<double[], Integer[]> points = new TreeMap<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                }
                if (o1[0] == o2[0]) {
                    return 0;
                } else return 1;
            }
        });

        for (int i = 0; i < listOfLines.size(); i++) {
            double ax1 = listOfLines.get(i)[0][0];
            double ay1 = listOfLines.get(i)[0][1];
            double ax2 = listOfLines.get(i)[1][0];
            double ay2 = listOfLines.get(i)[1][1];
            for (int j = i + 1; j < listOfLines.size(); j++) {
                double bx1 = listOfLines.get(j)[0][0];
                double by1 = listOfLines.get(j)[0][1];
                double bx2 = listOfLines.get(j)[1][0];
                double by2 = listOfLines.get(j)[1][1];

                double[] intersection = findIntersection(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
                if (intersection != null) {
                    points.put(intersection, new Integer[]{i, j});
                }
            }
        }
        if (!points.isEmpty()) {
            Map.Entry<double[], Integer[]> entry = points.firstEntry();
            System.out.println("Intersection of lines " + entry.getValue()[0]
                    + " and " + entry.getValue()[1] + " has the smallest X: (" + entry.getKey()[0] + ", " + entry.getKey()[1] + ")");
        } else {
            System.out.println("The lines have no intersections");
        }
    }

        private static double[] findIntersection ( double ax1, double ay1, double ax2, double ay2,
        double bx1, double by1, double bx2, double by2){
            double A1 = ay1 - ay2;
            double B1 = ax2 - ax1;
            double C1 = ax1 * ay2 - ax2 * ay1;

            double A2 = by1 - by2;
            double B2 = bx2 - bx1;
            double C2 = bx1 * by2 - bx2 * by1;

            double denominator = A1 * B2 - A2 * B1;
            if (denominator == 0) {
                return null;
            }

            double x = -(C1 * B2 - C2 * B1) / denominator;
            double y = -(A1 * C2 - A2 * C1) / denominator;

            if (checkIfPointBelongsToSegment(x, y,
                    ax1, ax2, ay1, ay2,
                    bx1, bx2, by1, by2)) {
                return new double[]{x, y};
            } else {
                return null;
            }
        }

    private static boolean checkIfPointBelongsToSegment(double x, double y,
                                                        double ax1, double ax2, double ay1, double ay2,
                                                        double bx1, double bx2, double by1, double by2) {
        boolean belongsToASegmentX = false;
        boolean belongsToASegmentY = false;
        boolean belongsToBSegmentX = false;
        boolean belongsToBSegmentY = false;
        if (((ax1 <= x) && (x <= ax2)) || ((ax2 <= x) && (x <= ax1))) {
            belongsToASegmentX = true;
        }
        if (((ay1 <= y) && (y <= ay2)) || ((ay2 <= y) && (y <= ay1))) {
            belongsToASegmentY = true;
        }
        if (((bx1 <= x) && (x <= bx2)) || ((bx2 <= x) && (x <= bx1))) {
            belongsToBSegmentX = true;
        }
        if (((by1 <= y) && (y <= by2)) || ((by2 <= y) && (y <= by1))) {
            belongsToBSegmentY = true;
        }
        if (belongsToASegmentX && belongsToASegmentY && belongsToBSegmentX && belongsToBSegmentY) {
            return true;
        } else {
            return false;
        }
    }

    public static class Cell implements Comparable {
        public static double[] circleCenter;
        public double[] cellCenter;

        public static void setCircleCenter(double[] center) {
            circleCenter = center;
        }

        public Cell(double[] cellCenter) {
            this.cellCenter = cellCenter;
        }

        @Override
        public int compareTo(Object o) {
            Cell obj = (Cell) o;
            double thisDistance = findDistance(cellCenter[0], circleCenter[0], cellCenter[1], circleCenter[1]);
            double oDistance = findDistance(obj.cellCenter[0], circleCenter[0], obj.cellCenter[1], circleCenter[1]);
            if (thisDistance < oDistance) {
                return -1;
            }
            if (thisDistance > oDistance) {
                return 1;
            }
            else return 0;
        }
    }

    public static void task7() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("Please enter a double for radius: ");
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();

        System.out.println("Please a double for Xo: ");
        double xCenter = scanner.nextDouble();
        System.out.println("Please a double for Yo: ");
        double yCenter = scanner.nextDouble();

        double xMin = (int) Math.ceil(xCenter - radius);
        double xMax = (int) Math.floor(xCenter + radius);
        double yMin = (int) Math.ceil(yCenter - radius);
        double yMax = (int) Math.floor(yCenter + radius);

        double x1 = xMin;
        double y1 = yMin;

        PriorityQueue<Cell> queue = new PriorityQueue<>();

        for (int i = 0; (x1 + i) <= xMax; i++) {
            x1 = x1 + i;
            for (int j = 0; (y1 + j <= yMax); j ++){
                y1 = y1 + j;
                double distance = findDistance(x1, xCenter, y1, yCenter);
                if (dotBelongsToCircle(distance, radius)) {
                    double[] dot2 = new double[]{x1 + 1, y1};
                    double[] dot3 = new double[]{x1, y1 + 1};
                    double[] dot4 = new double[]{x1 + 1, y1 + 1};
                    Cell cell = findCellCenterCoordinates(new double[] {x1, y1}, dot2, dot3, dot4, xCenter, yCenter, radius);
                    cell.setCircleCenter(new double[]{xCenter, yCenter});
                    if (cell != null) {
                        queue.add(cell);
                    }
                }
                y1 = yMin;
            }
            y1 = yMin;
            x1 = xMin;
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("priority-queue.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Could not create file \"priority-queue.txt\"!");
            ex.printStackTrace();
            throw ex;
        }
        Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            Cell cell = (Cell) iterator.next();
            double[] cellCenter = cell.cellCenter;
            writer.println("(" + cellCenter[0] + ", " + cellCenter[1] + ")");
        }
        writer.println("Number of cells: " + queue.size());
        writer.close();
    }

    public static double findDistance(double x1, double xCenter, double y1, double yCenter) {
        return Math.abs(Math.sqrt((Math.pow((x1 - xCenter), 2)) + (Math.pow((y1 - yCenter), 2))));
    }

    public static boolean dotBelongsToCircle(double distance, double radius) {
        if (distance <= radius) {
            return true;
        } else return false;
    }

    public static Cell findCellCenterCoordinates(double[] dot1, double[] dot2, double[] dot3, double[] dot4,
                                                 double xCenter, double yCenter, double radius) {
          double dot2Distance = findDistance(dot2[0], xCenter, dot2[1], yCenter);
          boolean dot2belongs = dotBelongsToCircle(dot2Distance, radius);
          if (!dot2belongs) {
              return null;
          }

          double dot3Distance = findDistance(dot3[0], xCenter, dot3[1], yCenter);
          boolean dot3belongs = dotBelongsToCircle(dot3Distance, radius);
          if (!dot3belongs) {
              return null;
          }

          double dot4Distance = findDistance(dot4[0], xCenter, dot4[1], yCenter);
          boolean dot4belongs = dotBelongsToCircle(dot4Distance, radius);
          if (!dot4belongs) {
              return null;
          }

          double[] cellCenter = new double[] {(dot1[0] + 0.5), (dot1[1] + 0.5)};
          return new Cell(cellCenter);
        }


    private static void printCollection(String comment, Collection collection) {
        System.out.println(comment);
        for (Object item : collection) {
            System.out.println(item);
        }
    }

    public static class Car {
        private int carNumber;
        private double location;
        private double speed;
        private double timeConsumed;

        Car(int carNumber, double location, double speed, double distance) {
            this.carNumber = carNumber;
            this.location = location;
            this.speed = speed;
            this.timeConsumed = (distance - location) / speed;
        }

        public int getCarNumber() {
            return carNumber;
        }

        public void printCar() {
            StringBuilder builder = new StringBuilder()
                    .append("Car number: ")
                    .append(carNumber)
                    .append(", ")
                    .append("location: ")
                    .append(location)
                    .append(", ")
                    .append("speed: ")
                    .append(speed)
                    .append(", ")
                    .append("time: ")
                    .append(timeConsumed)
                    .append(".");
            System.out.println(builder.toString());
        }
    }

    public static void task10() {
        final double distance = 100.0;

        ArrayList<Car> carsOnStart = new ArrayList<>();
        carsOnStart.add(new Car(1, 0.1, 50.0, distance));
        carsOnStart.add(new Car(2, 0.2, 60.0, distance));
        carsOnStart.add(new Car(3, 0.3, 60.0, distance));
        carsOnStart.add(new Car(4, 0.4, 70.0, distance));
        carsOnStart.add(new Car(5, 0.4, 50.0, distance));
        carsOnStart.add(new Car(6, 0.6, 70.0, distance));
        carsOnStart.add(new Car(7, 0.7, 60.0, distance));

        Comparator comparatorByLocation = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Car car1 = (Car) o1;
                Car car2 = (Car) o2;

                double location1 = car1.location;
                double location2 = car2.location;

                if (location1 > location2) {
                    return 1;
                }
                if (location1 < location2) {
                    return -1;
                } else return 0;
            }
        };

        Comparator comparatorByTimeConsumed = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Car car1 = (Car) o1;
                Car car2 = (Car) o2;

                double timeConsumed1 = car1.timeConsumed;
                double timeConsumed2 = car2.timeConsumed;

                if (timeConsumed1 > timeConsumed2) {
                    return 1;
                }
                if (timeConsumed1 < timeConsumed2) {
                    return -1;
                } else return 0;
            }
        };

        Collections.sort(carsOnStart, comparatorByLocation);
        printCarCollection(carsOnStart);

        ArrayList<Car> carsOnFinish = (ArrayList<Car>) carsOnStart.clone();
        Collections.sort(carsOnFinish, comparatorByTimeConsumed);
        printCarCollection(carsOnFinish);

        int overtaking = 0;
        for (int i = 1; i <= carsOnStart.size(); i++) {
            int indexStart = getIndexByProperty(carsOnStart, i);
            int indexFinish = getIndexByProperty(carsOnFinish, i);
            int dif = indexStart - indexFinish;
            if (dif > 0) {
                System.out.println("Car number: " + i);
                System.out.println("Index start: " + indexStart);
                System.out.println("Index finish: " + indexFinish);
                System.out.println("Diff: " + dif);
                overtaking = overtaking + dif;
            }
        }
        System.out.println("Number of overtakings is: " + overtaking);
    }

    private static int getIndexByProperty(ArrayList<Car> cars, int i) {
        for (int j = 0; j < cars.size(); j++) {
            Car car = cars.get(j);
            if (car != null) {
                if (cars.get(j).getCarNumber() == i) {
                    return j;
                }
            }
        }
        return -1;
    }

    private static void printCarCollection(ArrayList<Car> arrayList) {
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Car car = (Car)iterator.next();
            car.printCar();
        }
    }

}
