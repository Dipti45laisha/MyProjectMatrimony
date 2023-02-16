package com.testrunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//cucumber
@CucumberOptions(features="src/test/resources/Features",glue="com/testingEcommerce/Stepdefinitions")
public class RunnerTest extends AbstractTestNGCucumberTests {

}

//fetures:represent the path of feature files
//glue: path of the StepDefination File


//@RunWith(Cucumber.class)  //JUNIT 
//@CucumberOptions(features="src/test/resources/Features",glue="com/testingEcommerce/Stepdefinitions")
//public class RunnerTest{
//
//}
