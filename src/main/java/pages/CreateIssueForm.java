package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CreateIssueForm {

  private Driver driver;

  private SelenideElement projectNameField = $(byId("project-field"));
  private SelenideElement issueTypeField = $(byId("issuetype-field"));
  private SelenideElement summaryField = $(byId("summary"));
  private SelenideElement reporterField = $(byId("reporter-field"));

  private SelenideElement textAreaOnDescription = $(byXpath("//*[@id='description-wiki-edit']//child::a[text()='Text']"));
  private SelenideElement descriptionTextArea = $(byId("description"));

  private SelenideElement submitButton = $(byId("create-issue-submit"));
  private SelenideElement successPopUpMessage = $(byClassName("aui-message-success"));
  private SelenideElement popUpContainsWebinarName = $(byXpath("//*[@id='aui-flag-container']//a[contains (text(), 'WEBINAR')]"));


  public CreateIssueForm(Driver driver) {
    this.driver = driver;
  }

  //projectField
  public void projectFieldIsClickable() {
    projectNameField.shouldBe(Condition.enabled);
  }

  public void clearProjectField() {
    projectNameField.clear();
  }

  public void enterProjectName(String projectName) {
    projectNameField.setValue(projectName);
  }

  public void tabProjectName() {
    projectNameField.pressTab();
  }

  //issueTypeField
  public void issueTypeFieldIsClickable() {
    issueTypeField.shouldBe(Condition.enabled);
  }

  public void clearIssueTypeField() {
    issueTypeField.clear();
  }

  public void enterIssueTypeName(String issueTypeName) {
    issueTypeField.setValue(issueTypeName);
  }

  public void tabIssueType() {
    issueTypeField.pressTab();
  }

  //summaryField
  public void summaryFieldIsClickable() {
    reporterField.shouldBe(Condition.enabled);
  }

  public void enterSummaryName(String summaryText) {
    summaryField.setValue(summaryText);
  }

  //reporterField
  public void reporterFieldIsClickable() {
    reporterField.shouldBe(Condition.enabled);
  }

  public void clearReporterField() {
    reporterField.clear();
  }

  public void enterReporterName(String reporterName) {
    reporterField.setValue(reporterName);
  }

  public void tabReporter() {
    reporterField.pressTab();
  }

  //textAreaOnDescription
  public void textAreaOnDescriptionIsEnable() {
    textAreaOnDescription.shouldBe(Condition.enabled);
  }

  public void theTextAreaOnDescriptionIsClickable() {
    textAreaOnDescription.click();
  }

  public void enterSomeDescription(String description) {
    descriptionTextArea.setValue(description);
  }

  public void clickSubmit() {
    submitButton.click();
  }

  public void isSuccessPopUpMessagePresent() {
    successPopUpMessage.waitUntil(Condition.visible, 3000);
  }

  public void successPopUpMessageConsistOf() {
    popUpContainsWebinarName.shouldBe(Condition.visible);
  }
}