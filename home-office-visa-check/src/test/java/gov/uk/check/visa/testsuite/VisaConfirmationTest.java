package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VisaConfirmationTest extends TestBase {
    @Test(groups = {"smoke"})
    public void anAustralianComingToUKForTourism() {
        clickOnElement(By.xpath("//div[@id='global-cookie-message']/div/div[2]/button[2]"));
        clickOnElement(By.xpath("//main[@id='content']/div[2]/div[1]/article/section[1]/a"));
        selectByVisibleTextFromDropDown(By.id("response"), "Australia");
        clickOnElement(By.xpath("//button[text()='Continue']"));
        clickOnElement(By.id("response-0"));
        clickOnElement(By.xpath("//button[text()='Continue']"));
        String actualText = getTextFromElement(By.xpath("//div[@class='govuk-!-margin-bottom-6']/h2"));
        Assert.assertEquals(actualText, "You will not need a visa to come to the UK");
    }

    @Test(groups = {"regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() {
        clickOnElement(By.xpath("//div[@id='global-cookie-message']/div/div[2]/button[2]"));
        clickOnElement(By.xpath("//main[@id='content']/div[2]/div[1]/article/section[1]/a"));
        selectByVisibleTextFromDropDown(By.id("response"), "Chile");
        clickOnElement(By.xpath("//button[text()='Continue']"));
        clickOnElement(By.id("response-1"));
        clickOnElement(By.xpath("//button[text()='Continue']"));
        clickOnElement(By.id("response-1"));
        clickOnElement(By.xpath("//button[text()='Continue']"));
        clickOnElement(By.id("response-0"));
        clickOnElement(By.xpath("//button[text()='Continue']"));
        String actualText = getTextFromElement(By.xpath("//div[@class='govuk-!-margin-bottom-6']/h2"));
        Assert.assertEquals(actualText, "You need a visa to work in health and care");

    }

    @Test(priority = 3)
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() {
        clickOnElement(By.xpath("//div[@id='global-cookie-message']/div/div[2]/button[2]"));
        clickOnElement(By.xpath("//main[@id='content']/div[2]/div[1]/article/section[1]/a"));
        selectByVisibleTextFromDropDown(By.id("response"), "Colombia");
        clickOnElement(By.xpath("//button[text()='Continue']"));
        clickOnElement(By.id("response-4"));
        clickOnElement(By.xpath("//button[text()='Continue']"));
        String actualText = getTextFromElement(By.xpath("//div[@class='govuk-!-margin-bottom-6']/h2"));
        Assert.assertEquals(actualText, "You may need a visa");

    }
}
