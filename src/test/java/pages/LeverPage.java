package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeverPage extends BasePage {

    private final By LEVER_HEADER = By.cssSelector(".posting-headline");
    private static final String EXPECTED_URL_PART = "jobs.lever.co/useinsider";

    public LeverPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLeverApplicationPageOpened() {
        try {
            wait.until(ExpectedConditions.urlContains(EXPECTED_URL_PART));
            System.out.println("Lever başvuru sayfası açıldı. URL: " + driver.getCurrentUrl());
            return true;
        } catch (TimeoutException e) {
            System.out.println("Lever sayfası beklenirken timeout. Mevcut URL: " + driver.getCurrentUrl());
            return false;
        }
    }
}
