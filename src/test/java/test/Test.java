package test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		tags = "@test",
		format = {"html:target/html-report/Report", "json:target/cucumber.json"}
		)
public class Test{
	
}