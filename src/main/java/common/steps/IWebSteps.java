package common.steps;

import common.setup.RunnerHooks;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import products.AllProducts;
import static common.selenium.steps.WebSteps.*;


public class IWebSteps {

    @Given("^I start the WebDriver with the \"([^\"]*)\" browser$")
    public static void IStartTheWebDriver(String driver)
    {AssertExecutedStep(StartWebDriver(driver));}

    @Given("^I stop the WebDriver$")
    public static void IStopTheWebDriver()
    {AssertExecutedStep(StopWebDriver());}

    @Given("^I navigate to the Home page")
    public static void INavigateToTheHomePage()
    {AssertExecutedStep(NavigateToHomePage(System.getProperty("currentURL")));}

    @Given("^I am on the \"([^\"]*)\" page")
    public static void IAmOnThePage(String pageName)
    {AssertExecutedStep(OnThePage(pageName));}

    @Given("^I switch to the \"([^\"]*)\" window$")
    public static void ISwitchToTheWindow(int windowNumber)
    {AssertExecutedStep(SwitchToWindow(windowNumber));}

    @Given("^I switch to the default content$")
    public static void ISwitchToTheDefaultContent()
    {AssertExecutedStep(SwitchToDefaultContent());}

    @Given("^I \"([^\"]*)\" the \"([^\"]*)\" element$")
    public static void IActTheElement(String act, String elementName)
    { VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(elementName)) +"\n"+ "Visibility of element " + elementName + " with selector " + AllProducts.getElementSelector(elementName));
        AssertExecutedStep(ActTheElement(act,elementName,AllProducts.getElementSelector(elementName)));}

    @Given("^The \"([^\"]*)\" element status should be \"([^\"]*)\"$")
    public static void TheElementStatusShouldBe(String elementName, String status)
    {VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(elementName)) +"\n"+ "Visibility of element " + elementName + " with selector " + AllProducts.getElementSelector(elementName));
        AssertExecutedStep(ElementStatusShouldBe(elementName,AllProducts.getElementSelector(elementName),status));}

    @Given("^I should find the \"([^\"]*)\" in the downloads$")
    public static void ICheckDownloads(String expectedFileName)
    {AssertExecutedStep(CheckDownloads(expectedFileName));}

    @Given("^I select the \"([^\"]*)\" \"([^\"]*)\" from the \"([^\"]*)\" dropdown$")
    public static void ISelectFromDropDownBy(String text, String attribute, String elementName)
    {VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(elementName)) +"\n"+ "Visibility of element " + elementName + " with selector " + AllProducts.getElementSelector(elementName));
        AssertExecutedStep(SelectFromDropDownBy(text,attribute,elementName,AllProducts.getElementSelector(elementName)));}

    @Given("^I click the \"([^\"]*)\" \"([^\"]*)\" from the \"([^\"]*)\" options of the \"([^\"]*)\" dropdown$")
    public static void IClickFromDropDownBy(String text, String attribute,String optionName, String elementName)
    {VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(elementName)) +"\n"+ "Visibility of element " + elementName + " with selector " + AllProducts.getElementSelector(elementName));
        AssertExecutedStep(ClickFromDropDownBy(text,attribute,elementName,AllProducts.getElementSelector(elementName),optionName,AllProducts.getElementSelector(optionName)));}

    @Given("^I upload the \"([^\"]*)\" file to the \"([^\"]*)\" element$")
    public static void IUploadTheFile(String fileName, String elementName)
    {VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(elementName)) +"\n"+ "Visibility of element " + elementName + " with selector " + AllProducts.getElementSelector(elementName));
        AssertExecutedStep(UploadFile(fileName,elementName,AllProducts.getElementSelector(elementName)));}

    @Given("^I upload the \"([^\"]*)\" file to the \"([^\"]*)\" element with keys$")
    public static void IUploadTheFileWithKeys(String fileName, String elementName)
    {VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(elementName)) +"\n"+ "Visibility of element " + elementName + " with selector " + AllProducts.getElementSelector(elementName));
        AssertExecutedStep(UploadFileWithKey(fileName,elementName,AllProducts.getElementSelector(elementName)));}

    @Given("^I rename the \"([^\"]*)\" file to the \"([^\"]*)\"$")
    public static void IRenameFileTo(String fileName, String textX)
    {AssertExecutedStep(RenameFile(fileName,textX));}

    @Given("^I delete the \"([^\"]*)\" file$")
    public static void IDeleteFile(String fileName)
    {AssertExecutedStep(DeleteFile(fileName));}

    @Given("^I select the \"([^\"]*)\" \"([^\"]*)\" from the \"([^\"]*)\" element$")
    public static void ISelectTheElementBy(String text,String attribute,String dropDownName)
    {VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(dropDownName)) +"\n"+ "Visibility of element " + dropDownName + " with selector " + AllProducts.getElementSelector(dropDownName));
        AssertExecutedStep(SelectFromDropDownBy(text,attribute,dropDownName,AllProducts.getElementSelector(dropDownName)));}

    @Given("^I click the \"([^\"]*)\" \"([^\"]*)\" from the \"([^\"]*)\" element$")
    public static void IClickTheElementBy(String text,String attribute,String selection,String dropDownName)
    {VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(dropDownName)) +"\n"+ "Visibility of element " + dropDownName + " with selector " + AllProducts.getElementSelector(dropDownName));
        AssertExecutedStep(ClickFromDropDownBy(text,attribute,dropDownName,AllProducts.getElementSelector(dropDownName),selection,AllProducts.getElementSelector(selection)));}

    @Given("^I select the \"([^\"]*)\" date in the \"([^\"]*)\" datepicker$")
    public static void ISelectTheDateInTheDatePicker(String date, String datePickerName)
    {VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(datePickerName)) +"\n"+ "Visibility of element " + datePickerName + " with selector " + AllProducts.getElementSelector(datePickerName));
        AssertExecutedStep(SelectDateInDatePicker(date,datePickerName,AllProducts.getElementSelector(datePickerName),AllProducts.getElementSelector("day_selector"),AllProducts.getElementSelector("done_button")));}

    @Given("^I \"([^\"]*)\" \"([^\"]*)\" into the \"([^\"]*)\" element$")
    public static void IIntoTheElement(String act, String entry, String elementName)
    { VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(elementName)) +"\n"+ "Visibility of element " + elementName + " with selector " + AllProducts.getElementSelector(elementName));
        AssertExecutedStep(IntoTheElement(act,entry, elementName, AllProducts.getElementSelector(elementName)));}

    @Given("^I should see the \"([^\"]*)\" element$")
    public static void IShouldSeeTheElement(String elementName)
    {AssertExecutedStep(ShouldSeeTheElement(elementName,AllProducts.getElementSelector(elementName)));}

    @Given("^I should not see the \"([^\"]*)\" element$")
    public static void IShouldTheElement(String elementName)
    {AssertExecutedStep(ShouldNotSeeTheElement(elementName,AllProducts.getElementSelector(elementName)));}

    @Given("^The \"([^\"]*)\" element \"([^\"]*)\" should be \"([^\"]*)\"$")
    public static void TheElementTextShouldBe(String elementName, String attribute, String condition, String entry)
    {VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(elementName)) +"\n"+ "Visibility of element " + elementName + " with selector " + AllProducts.getElementSelector(elementName));
        AssertExecutedStep(ElementTextShouldBe(elementName,AllProducts.getElementSelector(elementName),attribute,condition,entry ));}

    @Given("^The \"([^\"]*)\" element \"([^\"]*)\" should not be \"([^\"]*)\"$")
    public static void TheElementTextShouldNotBe(String elementName, String attribute, String condition, String entry)
    {VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(elementName)) +"\n"+ "Visibility of element " + elementName + " with selector " + AllProducts.getElementSelector(elementName));
        AssertExecutedStep(ElementTextShouldNotBe(elementName,AllProducts.getElementSelector(elementName),attribute,condition,entry ));}

    @Given("^I takes screenshot to \"([^\"]*)\"$")
    public static void ITakeScreenShot(String fileName)
    {
        final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        RunnerHooks.scenario.embed(screenshot, "image/jpg"); //stick it in the report
        AssertExecutedStep(TakeScreenShot(System.getProperty("ReportPath") + "/" + fileName));
    }

    @Given("^I wait \"([^\"]*)\" sec/s$")
    public static void IWaitSomeSec(int wait, String waitFor)
    {AssertExecutedStep(WaitSomeSec(wait,waitFor));}

    @Given("^I hit \"([^\"]*)\" on the keyboard$")
    public static void IHitOnTheKeyBoard(String key)
    {AssertExecutedStep(HitOnTheKeyBoard(key));}

    @Given("^I store the \"([^\"]*)\" element text as \"([^\"]*)\"$")
    public static void IStoreTheElementTextAsTheTextX(String elementName, String attribute, String textX)
    {VerifyExecutedStep(waitToAppear(AllProducts.getElementSelector(elementName)) +"\n"+ "Visibility of element " + elementName + " with selector " + AllProducts.getElementSelector(elementName));
        AssertExecutedStep(StoreElementTextAsTextX(elementName,AllProducts.getElementSelector(elementName),attribute,textX));}

    @Given("^I store the \"([^\"]*)\" text as \"([^\"]*)\"$")
    public static void IStoreTheTextAsTheTextX(String text,String textX)
    {AssertExecutedStep(StoreTextAsTextX(text,textX));}

    @Given("^I assert the \"([^\"]*)\" result with message \"([^\"]*)\"$")
    public static void AssertExecutedStep(String result)
    {
        if (!result.toUpperCase().contains("PASS")) {
            RunnerHooks.scenario.write(result);
            Assert.assertTrue(false);
        }
        else {
            RunnerHooks.scenario.write(result);}
    }

    @Given("^I verify the \"([^\"]*)\" result with message \"([^\"]*)\"$")
    public static void VerifyExecutedStep(String result)
    {
        if (!result.toUpperCase().contains("PASS")){
            RunnerHooks.scenario.write(result);}
    }


}
