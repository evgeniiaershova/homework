package patterns.prototype;

public abstract class Animal {
        boolean mammal;
        boolean hasTail;
        int fingersCount;
        String color;
        boolean canSwim;

        public Animal() {
        }

        public Animal(Animal target) {
            if (target != null) {
                this.mammal = target.mammal;
                this.hasTail = target.hasTail;
                this.fingersCount = target.fingersCount;
                this.color = target.color;
                this.canSwim = target.canSwim;
            }
        }

        public abstract Animal clone();

        @Override
        public boolean equals(Object object2) {
            if (!(object2 instanceof Animal)) return false;

            Animal animal2 = (Animal) object2;
            return animal2.mammal == mammal && animal2.hasTail == hasTail && animal2.fingersCount == fingersCount
                    && animal2.color.equals(color) && animal2.canSwim == canSwim;
        }
}
