package patterns.abstractfactory;

import patterns.abstractfactory.devices.*;

public class IOSDeviceFactory implements DeviceFactory{
    @Override
    public Tablet createTablet() {
        System.out.println("Create new IOSTablet() ");
        return new IOSTablet();
    }

    @Override
    public Watch createWatch(){
        System.out.println("Create new IOSWatch() ");
        return new IOSWatch();
    }

    @Override
    public Smartphone createSmartphone() {
        System.out.println("Create new IOSsmartphone() ");
        return new IOSsmartphone();
    }
}
