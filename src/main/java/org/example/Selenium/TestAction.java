package org.example.Selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Consumer;

import static java.security.Key.*;

public class TestAction {
    public WebDriver driver;
    public Properties properties;
    public String webUrl;


    public TestAction(WebDriver driver, String webUrl, Properties properties) {
        this.driver = driver;
        this.webUrl = webUrl;
        this.properties = properties;
    }

    public TestAction(WebDriver driver, String webUrl) {
        this.driver = driver;
        this.webUrl = webUrl;
    }

    public TestAction() {
    }


    //    Hàm Lấy đường dẫn Url của website
    public TestAction get(String webUrl) {
        this.driver.get( webUrl );
        return this;
    }

//    Hàm thoát trình duyệt
    public void quit() {
        this.driver.quit();
    }

//    Hàm thực hiện hành động đợi
    public TestAction pause(long milisecond) {
        try {
            Thread.sleep( milisecond );
        } catch (InterruptedException e) {
            System.out.printf( "Something went wrong when invole pause(%d)%n", milisecond );
            e.printStackTrace();
        }
        return this;
    }

//    Hàm kiểm tra sự tồn tại của dối tượng
    public WebElement checkExisting(WebElement element, boolean visible) {
        WebDriverWait wait = new WebDriverWait( this.driver, Duration.ofSeconds( 10 ) );
        if (visible) {
            try {
                wait.until( ExpectedConditions.visibilityOf( element ) );
                wait.until( ExpectedConditions.elementToBeClickable( element ) );
                return element;
            } catch (NoSuchElementException e) {
                System.out.printf("Could not find %s", e);
            }
        } else {
            try {
                wait.until( ExpectedConditions.invisibilityOf( element ) );
                return element;
            } catch (NoSuchElementException e) {
                System.out.printf( "Could not find %s", e);
            }
        }
        return element;
    }

//    Hàm nhập tự động giá trị
    public TestAction sendKeys (WebElement element, String value, boolean isVisible) {
        checkExisting( element, isVisible ).sendKeys(value);
        return this;
    }

//    Hàm click vào đối tượng
    public TestAction click (WebElement element, boolean isVisible) {
        checkExisting( element, isVisible ).click();
        return this;
    }

//    Hàm bỏ chọn - Đối với checkbox
    public TestAction uncheck(WebElement invincibleElement, WebElement clickableElement, boolean isVisible) {
        if(checkExisting( invincibleElement, isVisible ).isSelected()) {
            clickableElement.click();
        }
        return this;
    }

//    Hàm xóa và send giá trị mới
    public TestAction clearThenSendKeys(WebElement element, String value, boolean isVisible) {
        WebElement e = checkExisting( element, isVisible );
                    e.sendKeys( Keys.chord(Keys.CONTROL, "a"), Keys.DELETE ); //Mô phỏng hành động giữ nút Ctrl + A và sau đó ấn Delete
                    e.sendKeys( value );
        return this;
    }

//    Hàm lấy văn bản
    public TestAction getText( WebElement element, boolean isVisible, Consumer<String> callback ) {
        callback.accept( checkExisting( element, isVisible ).getText() );
        return this;
    }

}
