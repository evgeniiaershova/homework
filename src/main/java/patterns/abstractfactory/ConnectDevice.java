package patterns.abstractfactory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import patterns.abstractfactory.devices.Smartphone;
import patterns.abstractfactory.devices.Tablet;
import patterns.abstractfactory.devices.Watch;

public class ConnectDevice {

    @Test(dataProvider = "getData")
    public void connectDevice(DeviceFactory deviceFactory) {
        Smartphone smartphone = deviceFactory.createSmartphone();
        smartphone.connect();
        smartphone.synchronize();

        Watch watch = deviceFactory.createWatch();
        watch.connect();

        Tablet tablet = deviceFactory.createTablet();
        tablet.connect();
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {
                {new AndroidDeviceFactory()},
                {new IOSDeviceFactory()}
        };
    }


}
