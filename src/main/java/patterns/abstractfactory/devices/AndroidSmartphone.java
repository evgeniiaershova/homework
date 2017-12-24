package patterns.abstractfactory.devices;

public class AndroidSmartphone implements Smartphone {
    @Override
    public void call() {

    }

    @Override
    public void connect() {
        System.out.println("Android Smartphone connected");

    }

    @Override
    public void synchronize() {
        System.out.println("Android Smartphone synchronized");
    }
}
