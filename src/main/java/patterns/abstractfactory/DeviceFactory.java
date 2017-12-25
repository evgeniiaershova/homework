package patterns.abstractfactory;

import patterns.abstractfactory.devices.Smartphone;
import patterns.abstractfactory.devices.Tablet;
import patterns.abstractfactory.devices.Watch;

public interface DeviceFactory {

    public Tablet createTablet();
    public Watch createWatch();
    public Smartphone createSmartphone();

}
