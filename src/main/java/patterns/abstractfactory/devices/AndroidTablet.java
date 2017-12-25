package patterns.abstractfactory.devices;

public class AndroidTablet implements Tablet {
    @Override
    public boolean hasKeyboard() {
        return false;
    }

    @Override
    public void connect() {
        System.out.println("Android tablet connected");
    }

    @Override
    public void synchronize() {
        System.out.println("Android tablet synchronized");
    }
}
