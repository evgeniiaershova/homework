package patterns.abstractfactory.devices;

import patterns.abstractfactory.devices.Watch;

public class IOSWatch implements Watch {
    @Override
    public boolean wearOnArm() {
        return false;
    }

    @Override
    public void connect() {
        System.out.println("IOS Watch connectd");

    }

    @Override
    public void synchronize() {
        System.out.println("IOS Watch synchronized");

    }

    @Override
    public void synchronizeWithSmart(Smartphone smartphone) {

    }
}
