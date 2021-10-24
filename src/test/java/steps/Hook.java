package steps;

import Base.BaseUtil;


//import cucumber.api.PickleStepTestStep;
//import cucumber.api.TestCase;
//import gherkin.pickles.PickleStep;
//import io.cucumber.core.api.Scenario;


import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.asynchttpclient.config.AsyncHttpClientConfigHelper.Config;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;


/**
 * Created by Karthik on 31/01/2019.
 */

public class Hook extends BaseUtil{

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) {
        base.scenarioDef = base.features.createNode(scenario.getName());
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.prompt_for_download", false);
        System.setProperty("webdriver.chrome.whitelistedIps", "");
       
        
		/*
		 * File file = new File("E:\\chromedriver.exe"); ChromeDriverService service =
		 * new ChromeDriverService.Builder().usingDriverExecutable(file)
		 * .usingAnyFreePort().build();
		 */
        
        
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--incognito");
        options.addArguments("--test-type", "start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--ignore-certificate-errors");
         // options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1024,768");
        options.addArguments("--no-sandbox");
//    options.setCapability("proxy", proxy);
//    options.setCapability(CapabilityType.PROXY, proxy);
//     options.addArguments("--disable-async-dns");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--enable-automation");
        options.addArguments("--disable-setuid-sandbox");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--whitelisted-ips");
     options.addArguments("--port=8080");
       // options.setExperimentalOption("debuggerAddress", "8080");
        options.addArguments("--no-proxy-server");
       // options.addArguments("--remote-debugging-port=8080");
        base.Driver = new ChromeDriver(options);
        
        
        
        
        
    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : MOCK");
        base.Driver.quit();
       
    }
   
    @BeforeStep
    public void BeforeEveryStep(Scenario scenario) {
        System.out.println("Before every step " + scenario.getId());
    }

    @AfterStep
    public void AfterEveryStep(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
        //System.out.println("Before every step " + stepTestStep.getId());
    }

}
