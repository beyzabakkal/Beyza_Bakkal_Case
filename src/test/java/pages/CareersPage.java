package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CareersPage extends BasePage {

    private final By CAREERS_HEADER =
            By.xpath("//h1[contains(text(),'Ready to disrupt')]");
    private final By SEE_ALL_TEAMS_BTN =
            By.xpath("//a[contains(text(),'See all teams')]");
    private final By QA_TEAM_CARD =
            By.xpath("//h3[contains(text(),'Quality Assurance')]/parent::a");
    private final By LOCATIONS_HEADER =
            By.xpath("//h3[contains(text(),'Our Locations')]");
    private final By LOCATIONS_PREV_ARROW =
            By.cssSelector("i.icon-arrow-left.location-slider-prev");
    private final By LOCATIONS_NEXT_ARROW =
            By.cssSelector("i.icon-arrow-right.location-slider-next");


    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCareersPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CAREERS_HEADER));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean areLocationArrowsVisible() {
        try {
            scrollIntoView(LOCATIONS_HEADER);
            waitVisible(LOCATIONS_PREV_ARROW);
            waitVisible(LOCATIONS_NEXT_ARROW);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickSeeAllTeams() {
        scrollIntoView(SEE_ALL_TEAMS_BTN);
        jsClick(SEE_ALL_TEAMS_BTN);
        waitSeconds(4);
    }

    public void clickQATeam() {
        try {
            waitSeconds(2);
            scrollIntoView(QA_TEAM_CARD);
            jsClick(QA_TEAM_CARD);
        } catch (Exception e) {
            throw new RuntimeException("QA team card not found. " + e.getMessage());
        }
    }

}
