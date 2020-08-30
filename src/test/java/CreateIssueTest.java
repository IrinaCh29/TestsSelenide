import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateIssueForm;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CreateIssueTest {

  Driver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;
  CreateIssueForm createIssueForm = null;

  @BeforeMethod
  public void setUp() {
    Configuration.browser = "chrome";
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    createIssueForm = new CreateIssueForm(driver);
  }

    @Test
    public void createIssue() {
      loginPage.navigateTo();
      loginPage.enterUserName("IrinaChub");
      loginPage.enterPassword("IrinaChub");
      loginPage.clickLogin();

      homePage.userNameIsPresent();
      homePage.clickCreate();

      createIssueForm.projectFieldIsClickable();
      createIssueForm.clearProjectField();
      createIssueForm.enterProjectName("Webinar (WEBINAR)");
      createIssueForm.tabProjectName();

      createIssueForm.issueTypeFieldIsClickable();
      createIssueForm.clearIssueTypeField();
      createIssueForm.enterIssueTypeName("Task");
      createIssueForm.tabIssueType();


      createIssueForm.summaryFieldIsClickable();
      createIssueForm.enterSummaryName("Summary");


      createIssueForm.reporterFieldIsClickable();
      createIssueForm.clearReporterField();
      createIssueForm.enterReporterName("IrinaChub");
      createIssueForm.tabReporter();

      createIssueForm.textAreaOnDescriptionIsEnable();
      createIssueForm.theTextAreaOnDescriptionIsClickable();
      createIssueForm.enterSomeDescription("some text of description");

      createIssueForm.clickSubmit();

      createIssueForm.isSuccessPopUpMessagePresent();
      createIssueForm.successPopUpMessageConsistOf();
    }

    @AfterMethod()
    public void closeBrowser() {
      closeWebDriver();
    }
  }