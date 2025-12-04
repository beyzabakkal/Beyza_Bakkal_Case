package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitVisible(locator).click();
    }

    public void scrollIntoView(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
    }

    public void jsClick(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", el);
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void scrollPageDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800);");
    }

    public void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep(long ms) {
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }
}
