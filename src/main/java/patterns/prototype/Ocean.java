package patterns.prototype;

public class Ocean {

    public static void main(String[] args) {
        Whale whiteWhale = new Whale();
        whiteWhale.canSwim = true;
        whiteWhale.color = "dapple gray";
        whiteWhale.isKiller = false;
        whiteWhale.fingersCount = 0;
        whiteWhale.hasTail = true;
        whiteWhale.mammal = true;
        whiteWhale.print();

        Whale secondWhale = (Whale) whiteWhale.clone();
        secondWhale.color = "BLACK";
        secondWhale.print();


    }

}
