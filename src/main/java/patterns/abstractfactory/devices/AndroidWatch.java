package patterns.abstractfactory.devices;

public class AndroidWatch implements Watch {
    @Override
    public boolean wearOnArm() {
        return false;
    }

    @Override
    public void connect() {
        System.out.println("Android Watch connected");

    }

    @Override
    public void synchronize() {
        System.out.println("Android Watch synchronized");
    }
}
