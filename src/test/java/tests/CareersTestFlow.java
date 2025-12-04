package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CareersTestFlow extends BaseTest {

    @Test
    public void fullCareerFlowTest() {

        HomePage home = new HomePage(driver);
        CareersPage careers = new CareersPage(driver);
        QAPage qaPage = new QAPage(driver);
        OpenPositionsPage positions = new OpenPositionsPage(driver);
        LeverPage lever = new LeverPage(driver);

        home.open();
        home.acceptCookiesIfVisible();
        home.closePopupIfVisible();
        home.closeNotificationPopup();
        Assert.assertTrue(home.isHomePageOpened(), "Insider home page should be opened.");

        home.hoverCompanyMenu();
        home.clickCareers();
        Assert.assertTrue(careers.isCareersPageOpened(), "Careers page should be opened.");
        Assert.assertTrue(careers.areLocationArrowsVisible(),
                "Our Locations section slider arrows should be visible.");

        careers.clickSeeAllTeams();
        careers.clickQATeam();
        qaPage.clickSeeAllQAJobs();

        positions.waitForPageToBeReady();
        positions.filterByIstanbul();
        positions.filterByQADepartment();
        Assert.assertTrue(positions.isFirstJobVisible(),
                "First job card should be visible for Istanbul, Turkiye - Quality Assurance.");
        Assert.assertTrue(positions.doesFirstJobMatchFilters(),
                "At least one job card should be listed after filtering by Istanbul, Turkiye and Quality Assurance.");
        positions.clickFirstJobViewRole();

        Assert.assertTrue(lever.isLeverApplicationPageOpened(),
                "Clicking 'View Role' should redirect to Lever application form page.");
    }
}
