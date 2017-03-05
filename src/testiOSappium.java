import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class testiOSappium {

    public static void main(String[] args) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // appium 版本
        capabilities.setCapability("appium-version", "1.6.3");
        capabilities.setCapability("platformName", "iOS");
        // 要測試的 iOS 手機版本
        capabilities.setCapability("platformVersion", "10.2");
        // 要測試的模擬器名稱
        capabilities.setCapability("deviceName", "iPhone 7");
        // app 屬性的值要指向要測試的 .app 或 .ipa 檔案
        capabilities.setCapability("app", "/Users/hsuhsiaohsuan/Desktop/ios test app/testAppiumiOS.app");
        // 設定手機螢幕是直向
        capabilities.setCapability("deviceOrientation", "portrait");

        // 初始化 WebDriver 連線到 appium server
        WebDriver wd = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        clickMe(wd);

        // 離開測試
        wd.quit();
    }

    // 按下"click me"按鈕，再按下彈出視窗的"OK"
    private static void clickMe(WebDriver wd) {
        wd.findElement(By.name("click me")).click();
        wd.findElement(By.name("OK")).click();
    }
}
