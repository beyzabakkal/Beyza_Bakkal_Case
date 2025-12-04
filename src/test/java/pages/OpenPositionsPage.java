package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenPositionsPage extends BasePage {

    private final By LOCATION_DROPDOWN =
            By.cssSelector("#select2-filter-by-location-container");
    private final By LOCATION_ISTANBUL_OPTION =
            By.xpath("//li[contains(text(),'Istanbul, Turkiye')]");
    private final By DEPARTMENT_DROPDOWN =
            By.cssSelector("#select2-filter-by-department-container");
    private final By DEPARTMENT_QA_OPTION =
            By.xpath("//li[contains(text(),'Quality Assurance')]");
    private final By FIRST_JOB_CARD =
            By.cssSelector("div.position-list-item-wrapper.bg-light");
    private final By FIRST_JOB_TITLE =
            By.cssSelector("p.position-title.font-weight-bold");
    private final By FIRST_JOB_DEPARTMENT =
            By.cssSelector("span.position-department");
    private final By FIRST_JOB_LOCATION =
            By.cssSelector("div.position-location");
    private final By FIRST_JOB_VIEW_ROLE_BTN =
            By.xpath("(//a[contains(text(),'View Role')])[1]");

    public OpenPositionsPage(WebDriver driver) {
        super(driver);
    }

    public void filterByIstanbul() {
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(LOCATION_DROPDOWN)
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown).perform();

        dropdown.click();
        sleep(400);

        WebElement istanbul = wait.until(
                ExpectedConditions.elementToBeClickable(LOCATION_ISTANBUL_OPTION)
        );

        istanbul.click();
    }

    public void filterByQADepartment() {
        WebElement dep = wait.until(
                ExpectedConditions.elementToBeClickable(DEPARTMENT_DROPDOWN)
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(dep).perform();

        dep.click();
        sleep(400);

        WebElement qa = wait.until(
                ExpectedConditions.elementToBeClickable(DEPARTMENT_QA_OPTION)
        );

        qa.click();
    }

    public void clickFirstJobViewRole() {
        waitSeconds(2);
        String originalTab = driver.getWindowHandle();

        scrollIntoView(FIRST_JOB_VIEW_ROLE_BTN);
        jsClick(FIRST_JOB_VIEW_ROLE_BTN);

        wait.until(driver -> driver.getWindowHandles().size() > 1);

        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }

    public boolean isFirstJobVisible() {
        WebElement card = wait.until(
                ExpectedConditions.presenceOfElementLocated(FIRST_JOB_CARD)
        );
        scrollIntoView(FIRST_JOB_CARD);
        return card != null;
    }

    public boolean doesFirstJobMatchFilters() {
        scrollIntoView(FIRST_JOB_CARD);
        java.util.List<WebElement> cards = driver.findElements(FIRST_JOB_CARD);
        return cards != null && !cards.isEmpty();
    }


    public void waitForPageToBeReady() {
        waitSeconds(10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("select2-filter-by-location-container")
        ));
    }


}
