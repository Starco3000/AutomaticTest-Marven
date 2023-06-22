package org.example.Selenium.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.function.Consumer;

public class Driver {
    static WebDriver driver;

    public void execute(Consumer<WebDriver> callback ) {
        callback.accept( driver );
    }

//    Hàm sử dụng trình duyệt Edge
    public WebDriver useEdge() {
//        WebDriverManager webDriverManager = WebDriverManager.edgedriver();
//        webDriverManager.setup();
        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
//        options.addArguments( "--start-maximized" );
//        options.setHeadless( true );
        options.addArguments("--disable-notifications");

        driver = new EdgeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }

//    Hàm sử dụng trình duyệt Chrome
    public WebDriver useChrome() {
        String downloadFilepath = "D:\\AutoTest\\AutoDownLoad-demo"; // Set đường dẫn đến directory chỉ định

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath); //Download và dẫn đến địa chỉ chỉ định

        options.setExperimentalOption("prefs",chromePrefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize(); // Cách viết khác của options.addArguments( "--start-maximized" );

        return driver;
    }
}
