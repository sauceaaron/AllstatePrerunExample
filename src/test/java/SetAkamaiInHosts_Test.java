import com.saucelabs.saucerest.SauceREST;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SetAkamaiInHosts_Test
{
	@Test
	public void test() throws IOException, InterruptedException
	{
		// get environment variables
		String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
		String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

		// upload prerun executable
		SauceREST api = new SauceREST(SAUCE_USERNAME, SAUCE_ACCESS_KEY);
		ClassLoader loader = SetAkamaiInHosts_Test.class.getClassLoader();
		File prerun = new File(loader.getResource("set-akamai-in-hosts-windows.bat").getFile());
		api.uploadFile(prerun);
		Thread.sleep(30000);

		// get Sauce url
		URL url = new URL ("https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.saucelabs.com/wd/hub");

		// set capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", "Windows 7");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("version", "latest");
		capabilities.setCapability("name", "should have Akamai header with spoofed hosts file");

		// get network information
		capabilities.setCapability("extendedDebugging", true);

		// use prerun executable before starting test
		capabilities.setCapability("prerun", "sauce-storage:set-akamai-in-hosts-windows.bat");

		// create webdriver
		RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);

		// execute script
		driver.get("https://purchase-stest.allstate.com/onlineshopping/welcome");
		System.out.println(driver.getTitle());

		// cleanup
		driver.quit();
	}
}
