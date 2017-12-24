package patterns.abstractfactory.devices;

public class IOSsmartphone implements Smartphone{

    @Override
    public void call() {

    }

    @Override
    public void connect() {
        System.out.println("IOS Smartphone connected");

    }

    @Override
    public void synchronize() {
        System.out.println("IOS Smartphone synchronized");

    }
}
