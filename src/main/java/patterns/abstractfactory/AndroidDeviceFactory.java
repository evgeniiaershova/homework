package patterns.abstractfactory;

import patterns.abstractfactory.devices.*;

public class AndroidDeviceFactory implements DeviceFactory {

    @Override
    public Tablet createTablet() {
        System.out.println("Create new AndroidTablet() ");
        return new AndroidTablet();
    }

    @Override
    public Watch createWatch() {
        System.out.println("Create new AndroidWatch() ");
        return new AndroidWatch();
    }

    @Override
    public Smartphone createSmartphone() {
        System.out.println("Create new AndroidSmartphone() ");
        return new AndroidSmartphone();
    }

}
