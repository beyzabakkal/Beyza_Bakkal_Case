package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage extends BasePage {

    private final By COOKIES_BTN = By.id("wt-cli-accept-all-btn");
    private final By SALE_POPUP_CLOSE_BTN = By.id("Anniversary2023Close");
    private final By NOTIFICATION_CLOSE_BTN = By.cssSelector(".close-text");
    private final By COMPANY_MENU_NAV = By.xpath("//a[normalize-space()='Company']");
    private final By CAREERS_LINK = By.xpath("//a[contains(@href,'/careers')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://useinsider.com/");
    }

    public boolean isHomePageOpened() {
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        return url.contains("useinsider.com") && title.toLowerCase().contains("insider");
    }

    public void acceptCookiesIfVisible() {
        try {
            driver.findElement(COOKIES_BTN).click();
        } catch (Exception ignored) {
        }
    }

    public void closePopupIfVisible() {
        try {
            driver.findElement(SALE_POPUP_CLOSE_BTN).click();
        } catch (Exception ignored) {
        }
    }

    public void closeNotificationPopup() {
        try {
            waitSeconds(1);

            List<WebElement> popups = driver.findElements(NOTIFICATION_CLOSE_BTN);

            if (!popups.isEmpty() && popups.get(0).isDisplayed()) {
                popups.get(0).click();
            }

        } catch (Exception ignored) {
        }
    }


    public void hoverCompanyMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(COMPANY_MENU_NAV)).perform();
    }

    public void clickCareers() {
        click(CAREERS_LINK);
    }
}
