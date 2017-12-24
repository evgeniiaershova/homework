package patterns.abstractfactory.devices;

public class IOSTablet implements Tablet{
    @Override
    public boolean hasKeyboard() {
        return false;
    }

    @Override
    public void connect() {
        System.out.println("IOS Tablet connected");
    }

    @Override
    public void synchronize() {
        System.out.println("IOS Tablet synchronize");

    }
}
