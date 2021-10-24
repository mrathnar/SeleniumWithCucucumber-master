package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Created by Karthik on 21/09/2019.
 */


@CucumberOptions(features = {"src/test/java/features"} , plugin = {"json:target/cucumber.json", "pretty"},
        glue = "steps")
public class TestRunner2 extends AbstractTestNGCucumberTests {


	/*
	 * boolean b=true;
	 * 
	 * @Override
	 * 
	 * @DataProvider (parallel =true) //-- For parallel execution support (which is
	 * not going to work for our code) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */

}
