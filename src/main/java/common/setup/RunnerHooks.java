package common.setup;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import products.AllProducts;
import products.AllURLs;

import org.joda.time.DateTime;

import static common.steps.IWebSteps.*;
import static common.util.DataHelp.getTimeStamp;

public class RunnerHooks {

    public static boolean wantsToQuit = false;
    public static Scenario scenario;
    public static String myScenario;

    @Before
    public void setup(Scenario scenario) throws Exception
    {
        // local use, comment before push
        System.setProperty("runDriver","chrome");
        System.setProperty("seleniumGrid","local");
        System.setProperty("runEnvironment","QA");

        this.scenario = scenario;

        if(wantsToQuit)
            throw new RuntimeException("Test FAIL : Cucumber wants to quit");

        myScenario = scenario.getName();
        System.setProperty("scenario",myScenario);
        System.setProperty("product",myScenario.substring(0,myScenario.indexOf("-")).replace(" ",""));

        System.setProperty("projectPath",System.getProperty("user.dir"));
        System.setProperty("systemTime", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        System.setProperty("userID",System.getProperty("user.home").replace("C:\\Users\\",""));
        System.setProperty("downloadPath",System.getProperty("user.home")+"\\Downloads");
        System.setProperty("reportPath",System.getProperty("projectPath")+"\\target\\cucumber-reports");
        System.getProperty("filePath",System.getProperty("projectPath") + "\\src\\main\\resources\\files\\");

        System.out.println("Product Tests Starts \n");
        System.out.println("************************************************************************************\n");
        System.out.println("Scenario : " + myScenario + "\n");
        System.setProperty("currentURL", AllURLs.getProductURL());
        System.out.println("CurrentURL : " + System.getProperty("currentURL") + "\n");
        System.out.println("************************************************************************************\n");

        System.out.println("ProjectPath : " + System.getProperty("projectPath") + "\n");
        System.out.println("ReportPath : " + System.getProperty("reportPath") + "\n");
        System.out.println("FilePath : " + System.getProperty("filePath") + "\n");
        System.out.println("SystemTime : " + System.getProperty("systemTime") + "\n");
        System.out.println("WebDriver : " + System.getProperty("runDriver") + "\n");
        System.out.println("Environment : " + System.getProperty("runEnvironment") + "\n");
        System.out.println("SeleniumGrid : " + System.getProperty("seleniumGrid") + "\n");
        System.out.println("************************************************************************************\n");

        IStartTheWebDriver(System.getProperty("runDriver"));


    }

    @After
    public static void tearDown(Scenario screnario) throws Exception
    {
        if(screnario.isFailed())
        {
            ITakeScreenShot(myScenario + "_failed_" + getTimeStamp("YYYY-MM-DD-HH-mm-ss-SSS"));
            IStopTheWebDriver();
            System.out.println("Test Failed ! \n");
        }

        else{
            System.out.println("Test Passed ! \n");
            IStopTheWebDriver();
        }




    }

    //-----------------------------------------------------------------------------//

}
