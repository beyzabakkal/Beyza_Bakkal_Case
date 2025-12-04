package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QAPage extends BasePage {

    private final By SEE_ALL_QA_JOBS_BTN = By.xpath("//a[contains(text(),'See all QA jobs')]");

    public QAPage(WebDriver driver) {
        super(driver);
    }

    public void clickSeeAllQAJobs() {
        waitSeconds(2);

        scrollIntoView(SEE_ALL_QA_JOBS_BTN);
        jsClick(SEE_ALL_QA_JOBS_BTN);
    }
}
