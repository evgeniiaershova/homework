package patterns.abstractfactory.devices;

public interface Watch {

    public boolean wearOnArm();

    public void connect();
    public void synchronize();
    public void synchronizeWithSmart(Smartphone smartphone);
}
