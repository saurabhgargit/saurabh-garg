package utils;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



public class BaseClass {

    protected static MobileDriver driver;
    protected static DesiredCapabilities capabilities;

    private static String getDeviceName() {
            return Service.getDeviceInfo(Service.getAttachedAndroidDevices().get(0)).get("model");
    }

    private static String getDeviceVersion() {
            return Service.getDeviceInfo(Service.getAttachedAndroidDevices().get(0)).get("version");
    }

    public void initializeSuite() {

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getDeviceVersion());
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getDeviceName());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/src/test/resources/apps/com.monefy.app.lite_2021-08-21.apk");

    }

    public void tearDown() {
        System.out.println("In after suite");
        if (driver != null) {
            driver.quit();
        }
    }


}
