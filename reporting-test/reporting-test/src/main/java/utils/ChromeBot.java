package utils;

import java.io.File;
import java.net.URL;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.thoughtworks.selenium.SeleniumException;

public class ChromeBot extends TestWatcher {

protected WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	@Override
	protected void finished(Description description) {
		driver.quit();
	}

	@Override
	protected void starting(Description description) {
		try {
			
			URL url = Thread.currentThread().getContextClassLoader().getResource("chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", new File(url.getPath()).getCanonicalPath());
//			ChromeDriverService service = new Builder().usingDriverExecutable(new File(url.getPath())).build();
			driver = new ChromeDriver();
		} catch (Exception e) {
			throw new SeleniumException(e);
		}
	}

}
