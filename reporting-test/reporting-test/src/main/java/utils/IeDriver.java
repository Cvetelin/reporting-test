package utils;

import java.io.File;
import java.net.URL;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService.Builder;

import com.thoughtworks.selenium.SeleniumException;


public class IeDriver extends TestWatcher {
	
	protected WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	@Override
	protected void failed(Throwable e, Description description) {
	
	}

	@Override
	protected void finished(Description description) {
		driver.quit();
	}

	@Override
	protected void starting(Description description) {
		try {
			
			URL url = Thread.currentThread().getContextClassLoader().getResource("IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", new File(url.getPath()).getCanonicalPath());
			InternetExplorerDriverService service = new Builder().usingDriverExecutable(new File(url.getPath())).build();
			driver = new InternetExplorerDriver(service);
		} catch (Exception e) {
			throw new SeleniumException(e);
		}
	}

	@Override
	protected void succeeded(Description description) {
	
	}
	
	
}
