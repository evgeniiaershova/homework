package patterns.prototype;

public class Whale extends Animal {
    boolean isKiller;

    public Whale() {
    }

    public Whale(Whale target){
        super(target);
        if (target != null ){
            this.isKiller = target.isKiller;
        }
    }

    public void print() {
        String whale = new StringBuilder()
                .append("canSwim: ")
                .append(canSwim)
                .append(", ")
                .append(color)
                .append(", is killer: ")
                .append(isKiller)
                .append(", fingers: ")
                .append(fingersCount)
                .append(", is mammal ")
                .append(mammal)
                .append(", has tail: ")
                .append(hasTail)
                .toString();
        System.out.println(whale);
    }

    @Override
    public Animal clone() {
        return new Whale(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Whale) || !super.equals(object2)) return false;
        Whale whale2 = (Whale) object2;
        return whale2.isKiller == isKiller;
    }
}
