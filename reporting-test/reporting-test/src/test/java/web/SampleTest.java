package web;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import utils.ChromeBot;


public class SampleTest {
	
	@Rule
	public ExternalResource resource = new ExternalResource() {
	};
	
	
	@Rule
	public ChromeBot chrome = new ChromeBot();
	
	private WebDriver driver;
	
	@Before
	public void before () {
		driver = chrome.getDriver();
	}

	@Test
	public void sample () {
		
		driver.get("http://google.com");
		Assert.assertThat(driver.findElement(By.xpath("//div[@id='_eEe']")).getText(), Matchers.containsString("Google.bg"));
	}
}
